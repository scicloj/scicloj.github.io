-- Wrap tables so wide ones scroll inside their own container instead of
-- stretching the whole page on narrow screens. Bootstrap's .table-responsive
-- does exactly this. The Hugo site had the same problem on a few pages.

function Table(el)
  return pandoc.Div({ el }, pandoc.Attr("", { "table-responsive" }))
end
