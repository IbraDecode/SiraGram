from fastapi import APIRouter

router = APIRouter()

@router.post("/send")
async def send_notification(message: str):
    # Implement notification sending
    return {"message": "Notification sent"}