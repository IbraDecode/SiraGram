from fastapi import FastAPI
from routes import auth, smart, notify, session, chat
from telegram_client import client

app = FastAPI(title="SiraGram Backend", version="2.0-flash")

@app.on_event("startup")
async def startup_event():
    await client.start()

@app.on_event("shutdown")
async def shutdown_event():
    await client.stop()

app.include_router(auth.router, prefix="/auth", tags=["auth"])
app.include_router(smart.router, prefix="/smart", tags=["smart"])
app.include_router(notify.router, prefix="/notify", tags=["notify"])
app.include_router(session.router, prefix="/session", tags=["session"])
app.include_router(chat.router, prefix="/chat", tags=["chat"])

@app.get("/")
def read_root():
    return {"message": "SiraGram Backend API"}