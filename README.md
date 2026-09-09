The website of the [Scicloj](https://scicloj.org) group, published at
<https://scicloj.github.io>.

The site is built with [Quarto](https://quarto.org/), whose sources live at the
repository root. It was migrated from Hugo ([Doks](https://getdoks.org/)); the
legacy Hugo tree was removed at cutover, and the last Hugo-built deployment is
preserved in the `gh-pages` history.

### Local development

Requires [Quarto](https://quarto.org/docs/get-started/) and, for the generator
scripts, [babashka](https://github.com/babashka/babashka).

Render the whole site:

```bash
quarto render
```

Live preview with auto-reload:

```bash
quarto preview
```

The rendered site is written to `_site/` (git-ignored).

### URL preservation

The rewrite keeps every URL the Hugo site published. Each page therefore lives
at `<url-path>/index.qmd` — for example `/docs/community/about/` is
`docs/community/about/index.qmd`. Blog post directories use the *slugified post
title*, because that is what Hugo's `/blog/:title/` permalink produced.

`scripts/legacy-urls.txt` records the 66 URLs the Hugo site published, captured
from the deployed `gh-pages` branch. After rendering, check them with:

```bash
./scripts/verify-urls.sh
```

`scripts/post-render.sh` mirrors the blog feed to `/index.xml` and writes
redirect stubs for Hugo's old pagination URLs (`/blog/page/2/` etc.).

### Generated pages

Two pages are generated and should not be edited by hand — anything you write
into them is overwritten on the next render:

- **Tools and libraries** (`docs/resources/libs/index.qmd`) comes from
  `scripts/model.edn`, which holds the whole page as data: the tag legend
  (`:tags`), the prose above it (`:preamble`), the headings in order
  (`:sections`) and the libraries themselves (`:libs`). Adding a library,
  retagging one, rewording the intro and adding a new section are all edits to
  that file; `scripts/gen-libs.clj` never needs to change.

- **Contributors** (`contributors/**`) reproduces Hugo's `contributors`
  taxonomy from the `author:` field of every page.

Both run automatically as `pre-render:` hooks (see `_quarto.yml`), so editing
the data is enough — locally and in CI. They need [babashka](https://babashka.org);
the CI workflow installs it. To run one by hand, or to preview its output
without writing anything:

```bash
bb scripts/gen-libs.clj              # write the page, if it changed
bb scripts/gen-libs.clj --show       # print it to stdout instead
bb scripts/gen-contributors.clj
```

### Theme

`cosmo` (light) and `darkly` (dark) with a navbar toggle, matching the dark-mode
switch the Hugo site had. Shared rules live in `custom.scss`; the per-mode
navbar and background variables are in `theme-light.scss` / `theme-dark.scss`.
The blue-to-green gradient follows the
[macroexpand-2025](https://github.com/scicloj/macroexpand-2025) site.

### Emoji

The Hugo site had `enableEmoji`, so GitHub-style shortcodes such as `:star:`
rendered as emoji. `filters/emoji.lua` reproduces that in Quarto. Unknown
shortcodes are left as-is, which is also what Hugo did.

### Continuous integration

`.github/workflows/deploy-quarto.yml` has two jobs:

- **`build`** runs on every branch, pull request and manual dispatch. It
  renders, runs `scripts/verify-urls.sh`, and uploads `_site` as an artifact.
- **`deploy`** runs on pushes to `master` only. It downloads the artifact the
  build job already verified and publishes it to `gh-pages` via
  `peaceiris/actions-gh-pages`.

Deploying the built artifact rather than re-rendering means the published bytes
are exactly the ones the URL check passed. `verify-urls.sh` is therefore a real
release gate: if a legacy URL disappears, `build` fails and `deploy` never runs.

### Rollback

`gh-pages` carries the full deploy history, including every Hugo build. To roll
back, revert the offending commit on `master` and let the workflow republish, or
force `gh-pages` back to a known-good commit. The last Hugo-built commit is
`26868614`.

### Contributing

If you wish to have push permissions, please reach out to `@daslu`.

A pull request to `scripts/model.edn` or to the `.qmd` files would always be
great. For bigger changes, let us talk — use the
[Issues](https://github.com/scicloj/scicloj.github.io/issues) or reach out to
Daniel Slutsky at the [Clojurians Zulip chat](https://clojurians.zulipchat.com/).

## License

MIT License
