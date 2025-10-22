from fastapi import APIRouter, HTTPException
from telegram_client import client
from pydantic import BaseModel

router = APIRouter()

class SendMessageRequest(BaseModel):
    chat_id: int
    text: str

@router.get("/chats")
async def get_chats():
    try:
        dialogs = await client.get_dialogs()
        chat_list = []
        for dialog in dialogs:
            chat_list.append({
                "id": dialog.chat.id,
                "title": dialog.chat.title or dialog.chat.first_name or "Unknown",
                "type": dialog.chat.type
            })
        return {"chats": chat_list}
    except Exception as e:
        raise HTTPException(status_code=400, detail=str(e))

@router.get("/messages/{chat_id}")
async def get_messages(chat_id: int, limit: int = 20):
    try:
        messages = await client.get_messages(chat_id, limit=limit)
        message_list = []
        for msg in messages:
            message_list.append({
                "id": msg.id,
                "text": msg.text,
                "date": msg.date.isoformat(),
                "from_user": msg.from_user.id if msg.from_user else None,
                "chat_id": msg.chat.id
            })
        return {"messages": message_list}
    except Exception as e:
        raise HTTPException(status_code=400, detail=str(e))

@router.post("/send")
async def send_message(request: SendMessageRequest):
    try:
        await client.send_message(request.chat_id, request.text)
        return {"status": "sent"}
    except Exception as e:
        raise HTTPException(status_code=400, detail=str(e))