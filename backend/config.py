import os

# Telegram API Configuration
API_ID = int(os.getenv("API_ID", "21800647"))
API_HASH = os.getenv("API_HASH", "f088e630dbf4a16cb89830f2e411f6af")

# Smart Engine Key (Gemini API)
SMART_KEY = os.getenv("SMART_KEY", "AIzaSyDNnl0LoTVJUJxRhGzVQhFpbubCfZVv6dA")

# MongoDB Configuration (optional for sessions, preferences, sync)
MONGO_URI = os.getenv("MONGO_URI", "mongodb+srv://ibraramdan376_db_user:lzvLg6KeU84bVWj5@ubotku.mogdzhf.mongodb.net/")

# MTProto Servers (for reference)
MT_PROTO_TEST = "149.154.167.40:443"
MT_PROTO_PROD = "149.154.167.50:443"