import shlex

class InputHandler:
    def __init__(self, _input):
        self._input = _input
        self.cmd = None
        self.arguments = []
        self._parse_input()

    def _parse_input(self):
        parsed_input = shlex.split(self._input)
        self.cmd = parsed_input[0]
        for arg in parsed_input[1:]:
            self.arguments.append(arg)

