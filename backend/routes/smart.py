from fastapi import APIRouter
from pydantic import BaseModel
from utils.smart_engine import smart_reply

router = APIRouter()

class PromptRequest(BaseModel):
    prompt: str

class TextRequest(BaseModel):
    text: str
    target_lang: str = "en"

class ImageRequest(BaseModel):
    image_url: str

class VoiceRequest(BaseModel):
    audio_text: str

@router.post("/respond")
async def smart_respond(request: PromptRequest):
    response = smart_reply(request.prompt)
    return {"response": response}

@router.post("/summary")
async def smart_summary(request: PromptRequest):
    prompt = f"Summarize this conversation: {request.prompt}"
    summary = smart_reply(prompt)
    return {"summary": summary}

@router.post("/translate")
async def smart_translate(request: TextRequest):
    prompt = f"Translate to {request.target_lang}: {request.text}"
    translation = smart_reply(prompt)
    return {"translation": translation}

@router.post("/vision")
async def smart_vision(request: ImageRequest):
    prompt = f"Analyze this image: {request.image_url}"
    analysis = smart_reply(prompt)
    return {"analysis": analysis}

@router.post("/voice")
async def smart_voice(request: VoiceRequest):
    prompt = f"Convert voice to text or process: {request.audio_text}"
    result = smart_reply(prompt)
    return {"result": result}