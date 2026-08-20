#!/usr/bin/env bash
# Post-render fixups that keep legacy Hugo URLs alive.
set -euo pipefail

OUT="${QUARTO_PROJECT_OUTPUT_DIR:-_site}"
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

# The search index is written before this hook runs, so normalise it too.
if [[ -f "$OUT/search.json" ]]; then
  sed -i -e 's@/index\.html@/@g' -e 's@"index\.html@"./@g' "$OUT/search.json"
fi

echo "post-render: .nojekyll, clean URLs, sitemap normalised"
