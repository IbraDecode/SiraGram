from fastapi import APIRouter, HTTPException
from pyrogram import Client
from telegram_client import client

router = APIRouter()

@router.post("/send_otp")
async def send_otp(phone: str):
    try:
        await client.send_code(phone)
        return {"message": "OTP sent"}
    except Exception as e:
        raise HTTPException(status_code=400, detail=str(e))

@router.post("/verify_otp")
async def verify_otp(phone: str, code: str):
    try:
        await client.sign_in(phone, code)
        return {"message": "Logged in"}
    except Exception as e:
        raise HTTPException(status_code=400, detail=str(e))