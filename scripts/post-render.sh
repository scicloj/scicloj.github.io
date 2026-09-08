#!/usr/bin/env bash
# Post-render fixups that keep legacy Hugo URLs alive.
set -euo pipefail

OUT="${QUARTO_PROJECT_OUTPUT_DIR:-_site}"
SITE_URL="https://scicloj.github.io"
cd "$(dirname "$0")/.."

# Hugo published a site-wide feed at /index.xml alongside /blog/index.xml.
# Quarto only emits the listing feed, so mirror it to the root path.
if [[ -f "$OUT/blog/index.xml" ]]; then
  cp "$OUT/blog/index.xml" "$OUT/index.xml"
fi

# Hugo paginated /blog/ and /pages/. Quarto shows every post on one page, so
# these legacy pagination URLs redirect to the listing itself.
redirect_stub () {
  local path="$1" target="$2"
  mkdir -p "$OUT/$path"
  cat > "$OUT/$path/index.html" <<HTML
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Redirecting…</title>
<link rel="canonical" href="$target">
<meta http-equiv="refresh" content="0; url=$target">
<meta name="robots" content="noindex">
</head>
<body><p>This page has moved to <a href="$target">$target</a>.</p></body>
</html>
HTML
}

redirect_stub "blog/page/1" "/blog/"
redirect_stub "blog/page/2" "/blog/"
redirect_stub "blog/page/3" "/blog/"
redirect_stub "pages/page/1" "/pages/"

echo "post-render: legacy URL fixups applied"

# GitHub Pages runs Jekyll unless this marker exists. The deploy action adds one
# by default, but writing it here makes the output self-sufficient.
touch "$OUT/.nojekyll"

# Quarto links and lists pages as ".../index.html"; the published URLs are the
# directories themselves. Rewrite both so only one URL form is advertised.
find "$OUT" -name '*.html' -type f -print0 \
  | xargs -0 sed -E -i 's@(href|src)="([^"]*/)index\.html(["#?])@\1="\2\3@g'
sed -E -i 's@<loc>([^<]*/)index\.html</loc>@<loc>\1</loc>@g' "$OUT/sitemap.xml"

# Hugo put each page's content date in <lastmod>; Quarto puts the build time, so
# every deploy would tell crawlers that every page had just changed. Restore the
# content date from the page's own front matter -- `date-modified` if it has one,
# otherwise `date`. Pages declaring neither (the listing and contributor pages)
# keep the build time, which is honest: they really do change whenever content
# is added around them.
front_matter_date () {
  local src="$1" d
  [[ -f "$src" ]] || return 0
  local fm
  fm=$(awk 'NR==1 && /^---$/ {f=1; next} f && /^---$/ {exit} f' "$src")
  for key in date-modified date; do
    d=$(printf '%s\n' "$fm" \
        | sed -n "s/^${key}:[[:space:]]*[\"']\{0,1\}\([0-9]\{4\}-[0-9]\{2\}-[0-9]\{2\}\).*/\\1/p" \
        | head -1)
    if [[ -n "$d" ]]; then printf '%s' "$d"; return 0; fi
  done
  # No date declared: say so quietly. Returning non-zero here would trip the
  # script's `set -e` via the calling command substitution.
  return 0
}

rewrite_sitemap_lastmod () {
  local sm="$OUT/sitemap.xml" tmp loc path src date
  [[ -f "$sm" ]] || return 0
  tmp=$(mktemp)
  while IFS= read -r line; do
    case "$line" in
      *"<loc>"*)
        loc=${line#*<loc>}; loc=${loc%%</loc>*}
        printf '%s\n' "$line" >> "$tmp"
        ;;
      *"<lastmod>"*)
        path=${loc#"$SITE_URL"}; path=${path#/}; path=${path%/}
        if [[ -n "$path" ]]; then src="$path/index.qmd"; else src="index.qmd"; fi
        date=$(front_matter_date "$src")
        if [[ -n "$date" ]]; then
          printf '    <lastmod>%sT00:00:00+00:00</lastmod>\n' "$date" >> "$tmp"
        else
          printf '%s\n' "$line" >> "$tmp"
        fi
        ;;
      *) printf '%s\n' "$line" >> "$tmp" ;;
    esac
  done < "$sm"
  mv "$tmp" "$sm"
}

rewrite_sitemap_lastmod

# The search index is written before this hook runs, so normalise it too.
if [[ -f "$OUT/search.json" ]]; then
  sed -i -e 's@/index\.html@/@g' -e 's@"index\.html@"./@g' "$OUT/search.json"
fi

# Hugo emitted <link rel="canonical"> and og:url on every page; Quarto emits
# neither. Derive both from the file's location. Redirect stubs already declare
# their own canonical and are skipped, as is the 404 page.
while IFS= read -r -d '' f; do
  [[ "$f" == "$OUT/404.html" ]] && continue
  grep -q 'rel="canonical"' "$f" && continue
  rel="${f#"$OUT"/}"
  case "$rel" in
    index.html)   url="/" ;;
    */index.html) url="/${rel%index.html}" ;;
    *)            url="/$rel" ;;
  esac
  sed -i "s@</head>@<link rel=\"canonical\" href=\"${SITE_URL}${url}\">\n<meta property=\"og:url\" content=\"${SITE_URL}${url}\">\n</head>@" "$f"
done < <(find "$OUT" -name '*.html' -type f -print0)

echo "post-render: .nojekyll, clean URLs, sitemap normalised, canonical/og:url added"
