import os
import logging
import google.generativeai as genai

logger = logging.getLogger(__name__)
SMART_KEY = os.getenv("SMART_KEY", "AIzaSyDNnl0LoTVJUJxRhGzVQhFpbubCfZVv6dA")

# Configure the client
genai.configure(api_key=SMART_KEY)

def smart_reply(prompt):
    try:
        model = genai.GenerativeModel("gemini-2.0-flash")  # Use stable 2.0-flash
        response = model.generate_content(prompt)
        return response.text if response.text else "No response"
    except Exception as e:
        logger.error(f"Smart reply error: {e}")
        # Fallback to mock response for testing
        return f"Mock AI response: '{prompt}' processed successfully (API error: {str(e)})"