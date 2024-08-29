import unittest
from unittest.mock import patch, MagicMock
import os
from input_parser import InputHandler
from var import is_valid_option, return_value, assign_var

class TestScript(unittest.TestCase):
    
    def setUp(self):
        self.input_handler = InputHandler()
        
    @patch('script.InputHandler')
    def test_is_valid_option(self, MockInputHandler):
        MockInputHandler().option = ['-s']
        self.assertTrue(is_valid_option())
        MockInputHandler().option = ['-x']
        self.assertFalse(is_valid_option())

    @patch('script.os.fork', return_value=0)
    @patch('script.Builtin')
    @patch('script.InputHandler')
    def test_return_value_with_fork(self, MockInputHandler, MockBuiltin, mock_fork):
        MockInputHandler().option = ['-s']
        MockInputHandler().argument = ['var', 'echo', 'Hello']
        MockBuiltin.exec = MagicMock()
        value = return_value()
        MockBuiltin.exec.assert_called_with(None, 'echo')
        self.assertEqual(value, None)

    @patch('script.InputHandler')
    def test_return_value_without_fork(self, MockInputHandler):
        MockInputHandler().option = ['-x']
        MockInputHandler().argument = ['var', 'Hello']

        value = return_value()
        self.assertEqual(value, ['Hello'])

    @patch('script.os.environ', {})
    @patch('script.InputHandler')
    def test_assign_var(self, MockInputHandler):
        MockInputHandler().option = ['-x']
        MockInputHandler().argument = ['greeting', 'Hello, world!']

        assign_var()

        self.assertIn('greeting', os.environ)
        self.assertEqual(os.environ['greeting'], ['Hello, world!'])

if __name__ == '__main__':
    unittest.main()
