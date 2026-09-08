The website of the [Scicloj](https://scicloj.org) group, published at
<https://scicloj.github.io>.

The site is being rewritten from Hugo ([Doks](https://getdoks.org/)) to
[Quarto](https://quarto.org/). The Quarto sources live at the repository root;
the legacy Hugo tree (`content/`, `config/`, `layouts/`, `package.json`, …) is
still present and still owns the deployment until we cut over.

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

Two pages are generated and should not be edited by hand:

- **Tools and libraries** (`docs/resources/libs/index.qmd`) is generated from
  `scripts/model.edn`:

  ```bash
  bb scripts/gen-libs.clj libs.md
  ```

- **Contributors** (`contributors/**`) reproduces Hugo's `contributors`
  taxonomy from the `author:` field of every page. Re-run after adding or
  re-attributing a page:

  ```bash
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
  It never touches the live site, so it is safe to run before cutover.
- **`deploy`** publishes the artifact the build job already verified, to
  `gh-pages` via `peaceiris/actions-gh-pages`. It is guarded until cutover.

Deploying the built artifact rather than re-rendering means the published bytes
are exactly the ones the URL check passed.

### Cutover checklist

When the Quarto site is ready to take over:

1. In `.github/workflows/deploy-quarto.yml`, delete the `false &&` from the
   `deploy` job's `if:`, and delete `.github/workflows/deploy-github.yml` in
   the same commit so the two workflows never both own `gh-pages`.
2. Delete the Hugo tree: `content/`, `config/`, `layouts/`, `i18n/`, `data/`,
   `functions/`, `images/`, `theme.toml`, `netlify.toml`, `babel.config.js`,
   `package.json`, `package-lock.json`, and the lint configs.

### Contributing

If you wish to have push permissions, please reach out to `@daslu`.

A pull request to `scripts/model.edn` or to the `.qmd` files would always be
great. For bigger changes, let us talk — use the
[Issues](https://github.com/scicloj/scicloj.github.io/issues) or reach out to
Daniel Slutsky at the [Clojurians Zulip chat](https://clojurians.zulipchat.com/).

## License

MIT License
