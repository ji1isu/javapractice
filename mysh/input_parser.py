import shlex
import subprocess

class InputHandler:
    def __init__(self, _input):
        self._input = _input
        self.cmd = None
        self.option = [] #multiple options
        self.arguments = []
        self._parse_input()

    def isoption(self, arg):
        if arg[0] == '-':
            return True
        return False

    def add_options(self, argument):
        if self.isoption(argument):
            self.option.append(argument)
            print(argument)

    def _parse_input(self):
        parsed_input = shlex.split(self._input)
        self.cmd = parsed_input[0]
        for arg in parsed_input[1:]:
            if self.isoption(arg):
                self.add_options(arg)
            else:
                self.arguments.append(arg)

if __name__ == "__main__":
    input__ = "eg -o -another 'multiple args in here' -trickoption"
    inputhandle = InputHandler(input__)
    # inputhandle.parse_input()
    print(inputhandle.cmd)
    print(inputhandle.option)
    print(inputhandle.arguments)
