import os

# Telegram API Configuration
# Get your API_ID and API_HASH from https://my.telegram.org/auth
API_ID = int(os.getenv("API_ID", "YOUR_API_ID_HERE"))
API_HASH = os.getenv("API_HASH", "YOUR_API_HASH_HERE")

# Smart Engine Key (Gemini API)
SMART_KEY = os.getenv("SMART_KEY", "AIzaSyDNnl0LoTVJUJxRhGzVQhFpbubCfZVv6dA")

# MongoDB Configuration (optional for sessions, preferences, sync)
MONGO_URI = os.getenv("MONGO_URI", "mongodb+srv://ibraramdan376_db_user:lzvLg6KeU84bVWj5@ubotku.mogdzhf.mongodb.net/")

# MTProto Servers (for reference)
MT_PROTO_TEST = "149.154.167.40:443"
MT_PROTO_PROD = "149.154.167.50:443"