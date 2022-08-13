A draft for a Scicloj website redesign, based on the [Doks](https://getdoks.org/) Hugo theme.

### Local development

Install dependencies:

```bash
npm install
```

Start development server:

```bash
npm run start
```

Browse the locally developed website at localhost:1313.
Edit the markdown files under [content](./content) and see the website updating.

The [tools and libraries mardkown](./content/en/docs/resources/libs.md) is generated from [an EDN file](./content/en/docs/resources/model.edn). You can regenerate it using:

```bash
cd content/en/docs/resources/
./gen.clj libs.md
```
(assuming you have [babashka](https://github.com/babashka/babashka) installed)

### Contributing

If you wish to have push permissions, please reach out to `@daslu`. This would automatically be reflected in the website (after a delay of a minute or so).

A pull request to the `.md` files under the `content` directory would always be great.

For bigger changes, let us talk. You can use the [Issues](https://github.com/scicloj/scicloj-website/issues) or reach out to Daniel Slutsky at the [Clojurians Zulip chat](https://clojurians.zulipchat.com/).
