#!/usr/bin/env bash
# Verify that the rendered Quarto site still serves every URL the Hugo site
# published. The expected list in scripts/legacy-urls.txt was captured from the
# deployed gh-pages branch (every directory containing an index.html).
set -uo pipefail

cd "$(dirname "$0")/.."
OUT="${1:-_site}"
EXPECTED="scripts/legacy-urls.txt"

if [[ ! -d "$OUT" ]]; then
  echo "error: $OUT not found - run 'quarto render' first" >&2
  exit 1
fi

actual=$(cd "$OUT" && find . -name index.html | sed 's|^\.||; s|index\.html$||' | sort)
missing=$(comm -23 "$EXPECTED" <(echo "$actual"))
added=$(comm -13 "$EXPECTED" <(echo "$actual"))

status=0
if [[ -n "$missing" ]]; then
  echo "MISSING - published previously, absent now:"
  echo "$missing" | sed 's/^/  /'
  status=1
fi
if [[ -n "$added" ]]; then
  echo "NEW - not previously published (informational):"
  echo "$added" | sed 's/^/  /'
fi

[[ $status -eq 0 ]] && echo "OK - all $(wc -l < "$EXPECTED") legacy URLs are present in $OUT"
exit $status
