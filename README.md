# SiraGram

A modern Telegram client for Android with smart features, built with Java/Kotlin and a Python backend using Pyrogram and FastAPI.

## Features

- **Chat & Communication**: Private, group, and channel chats with voice/video calls.
- **Smart Features**: AI-powered assistant, compose, summary, translate, voice understanding, image insight, and search.
- **Security**: OTP login, encryption, two-step verification, and privacy modes.
- **UI/UX**: Material You design with dark theme, animations, and smooth transitions.

## Architecture

- **Frontend**: Android app (Java/Kotlin/XML) with MVVM architecture.
- **Backend**: Python FastAPI server with Pyrogram for Telegram integration and Gemini 2.0-flash for smart features.

## Setup

### Backend

1. Install dependencies:
   ```bash
   cd backend
   pip install -r requirements.txt
   ```

2. Set environment variables:
   - `API_ID`: Telegram API ID
   - `API_HASH`: Telegram API Hash
   - `SMART_KEY`: Gemini API Key

3. Run the server:
   ```bash
   uvicorn main:app --reload
   ```

### Android

1. Open in Android Studio.
2. Build and run on device/emulator.

## API Endpoints

- `/auth/send_otp` - Send OTP for login
- `/auth/verify_otp` - Verify OTP
- `/smart/respond` - Smart response
- `/smart/summary` - Summarize chat
- `/smart/translate` - Translate text
- `/chat/messages/{chat_id}` - Get messages
- `/chat/send` - Send message

## Contributing

Built by Ibra Decode with Sira Community.

## License

© Sira Community 2025