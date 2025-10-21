from fastapi import APIRouter, HTTPException
from utils.database import sessions, preferences
from pydantic import BaseModel

router = APIRouter()

class SessionData(BaseModel):
    user_id: str
    data: dict

@router.post("/sync")
async def sync_session(session: SessionData):
    try:
        sessions.update_one({"user_id": session.user_id}, {"$set": session.data}, upsert=True)
        return {"message": "Session synced"}
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

@router.get("/preferences/{user_id}")
async def get_preferences(user_id: str):
    pref = preferences.find_one({"user_id": user_id})
    return pref or {"message": "No preferences found"}

@router.post("/preferences")
async def save_preferences(pref: SessionData):
    try:
        preferences.update_one({"user_id": pref.user_id}, {"$set": pref.data}, upsert=True)
        return {"message": "Preferences saved"}
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))