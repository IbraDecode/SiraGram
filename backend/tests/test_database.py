import unittest
from utils.database import client, db, sessions

class TestDatabase(unittest.TestCase):
    def setUp(self):
        # Test data
        self.test_user = {"user_id": "test_user", "data": {"theme": "dark"}}

    def test_mongo_connection(self):
        # Test if we can connect and insert
        result = sessions.insert_one(self.test_user)
        self.assertIsNotNone(result.inserted_id)

        # Test retrieval
        doc = sessions.find_one({"user_id": "test_user"})
        self.assertIsNotNone(doc)
        if doc:
            self.assertEqual(doc["data"]["theme"], "dark")

        # Cleanup
        sessions.delete_one({"user_id": "test_user"})

    def tearDown(self):
        # Close connection if needed
        pass

if __name__ == '__main__':
    unittest.main()