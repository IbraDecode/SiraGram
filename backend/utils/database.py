from pymongo import MongoClient
from config import MONGO_URI

client = MongoClient(MONGO_URI)
db = client["siragram_db"]  # Database name

# Collections
sessions = db["sessions"]
preferences = db["preferences"]
sync_data = db["sync_data"]