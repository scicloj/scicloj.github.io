-- Render GitHub-style emoji shortcodes (`:star:`) as Unicode emoji.
--
-- The Hugo site had `enableEmoji = true`, so shortcodes throughout the content
-- were rendered as emoji. Quarto/Pandoc does not do this, so without this
-- filter they would show up literally as `:star:`.
--
-- Unknown shortcodes are left untouched, which is what Hugo did too (the
-- content contains a `:video:`, which is not a real shortcode and stayed
-- literal on the published site).

local emoji = {
  star = "⭐",
  movie_camera = "🎥",
  calendar = "📆",
  pray = "🙏",
  notebook = "📓",
  book = "📖",
  tada = "🎉",
  soccer = "⚽",
  megaphone = "📣",
  link = "🔗",

  -- Common extras, so newly written content behaves as it did under Hugo.
  smile = "😄",
  smiley = "😃",
  wave = "👋",
  rocket = "🚀",
  sparkles = "✨",
  fire = "🔥",
  bulb = "💡",
  warning = "⚠️",
  heavy_check_mark = "✔️",
  white_check_mark = "✅",
  x = "❌",
  point_right = "👉",
  eyes = "👀",
  clap = "👏",
  raised_hands = "🙌",
  thinking = "🤔",
  memo = "📝",
  pencil = "📝",
  books = "📚",
  chart_with_upwards_trend = "📈",
  bar_chart = "📊",
  computer = "💻",
  microphone = "🎤",
  headphones = "🎧",
  sound = "🔊",
  loud_sound = "🔊",
  speech_balloon = "💬",
  busts_in_silhouette = "👥",
  handshake = "🤝",
  hammer_and_wrench = "🛠️",
  wrench = "🔧",
  package = "📦",
  seedling = "🌱",
  sunflower = "🌻",
  herb = "🌿",
  earth_africa = "🌍",
  globe_with_meridians = "🌐",
  mag = "🔍",
  key = "🔑",
  lock = "🔒",
  bell = "🔔",
  alarm_clock = "⏰",
  hourglass = "⌛",
  date = "📅",
  pushpin = "📌",
  paperclip = "📎",
  page_facing_up = "📄",
  scroll = "📜",
  newspaper = "📰",
  mailbox = "📫",
  email = "📧",
  envelope = "✉️",
  telephone = "☎️",
  tv = "📺",
  camera = "📷",
  art = "🎨",
  musical_note = "🎵",
  game_die = "🎲",
  dart = "🎯",
  trophy = "🏆",
  medal = "🏅",
  crown = "👑",
  gift = "🎁",
  balloon = "🎈",
  confetti_ball = "🎊",
  ["100"] = "💯",
  zap = "⚡",
  snowflake = "❄️",
  sunny = "☀️",
  cloud = "☁️",
  umbrella = "☔",
  coffee = "☕",
  beer = "🍺",
  pizza = "🍕",
  apple = "🍎",
  cherry_blossom = "🌸",
  four_leaf_clover = "🍀",
  cat = "🐱",
  dog = "🐶",
  bird = "🐦",
  bug = "🐛",
  snake = "🐍",
  whale = "🐳",
  penguin = "🐧",
  owl = "🦉",
  butterfly = "🦋",
}

-- Match `:name:` where name is a plausible shortcode. Anything not in the
-- table above is returned unchanged.
local function expand(text)
  return (text:gsub(":([a-z0-9_+-]+):", function(name)
    local e = emoji[name]
    if e then
      return e
    end
    return ":" .. name .. ":"
  end))
end

function Str(el)
  if el.text:find(":") then
    local expanded = expand(el.text)
    if expanded ~= el.text then
      return pandoc.Str(expanded)
    end
  end
  return nil
end
