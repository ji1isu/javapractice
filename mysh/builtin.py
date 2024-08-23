from input_parser import InputHandler

class BuiltinResult:
    def __init__(self, stdout, stderr):
        self.stdout = stdout
        self.stderr = stderr

class BuiltinExit:
    def __init__(self, input_handler):
        self.input_handler = input_handler
    def exec(self):
        exit(0)

class BuiltinEg:
    def __init__(self, input_handler):
        self.input_handler = input_handler
    def exec(self):
        return BuiltinResult("This is example", "")

#class for all builtin command

class Builtin:
    def __init__(self):
        self.cmd_table = {
            "exit": BuiltinExit,
            "eg": BuiltinEg,
        }

    def exec(self, cmd):
        input_handler = InputHandler(cmd)
        print(input_handler.cmd)
        if input_handler.cmd not in self.cmd_table:
            return None
        handler = self.cmd_table[input_handler.cmd](input_handler)
        return handler.exec()
