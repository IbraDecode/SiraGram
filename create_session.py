from telethon import TelegramClient

# API credentials
API_ID = 21800647
API_HASH = "f088e630dbf4a16cb89830f2e411f6af"

# Create client
client = TelegramClient('siragram', API_ID, API_HASH)

# Run to create session (will prompt for phone and code)
client.start()

print("Session created: siragram.session")