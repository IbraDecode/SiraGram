import unittest
from utils.smart_engine import smart_reply

class TestSmartEngine(unittest.TestCase):
    def test_smart_reply(self):
        # Mock test
        result = smart_reply("Hello")
        self.assertIsInstance(result, str)

if __name__ == '__main__':
    unittest.main()