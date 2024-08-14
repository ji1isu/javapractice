class InputParser:
    def __init__(self, str_input):
        self.str_input = str_input
        self.user_input = []
        self.comm = ""
        self.comm_arg = []

    def get_input(self):
        self.user_input = self.str_input.split()

    def get_comm(self):
        if self.user_input:
            self.comm = self.user_input[0]
        return self.user_input

    def get_args(self):
        if len(self.user_input) > 1:
            self.comm_arg = self.user_input[1:]
        return self.comm_arg
        
    def process_command(self):
        pass
    def process_argument(self):
        pass

# tested all code, input gets parse -->how to process commands and arguments??
