import os
import json
import subprocess

from builtin import Builtin

#have a command table that you can add commands to(build in)
#builtin all

# make file reader . you need this to access prompt and intialise shell
class MySh:
    def __init__(self, config_path):
        self.config = read_json_file(config_path)
        self._prompt_set()

    def _prompt_set(self):
        self.prompt = os.getenv('PROMPT')
        if self.prompt is None:
            self.prompt = self.config["default_prompt"]

    def _get_cmd(self):
        return input(self.prompt)

if __name__ == "__main__":
    mysh = MySh(".myshrc")
    builtin = Builtin()
    while True:
        try:
            cmd = mysh._get_cmd()
        except EOFError:
            print(" ") #ctrl z, not d
            exit(0)
        except FileNotFoundError:
            print(f"mysh: command not found <{cmd}>")

        result = builtin.exec(cmd)
        if result == None:
            result = subprocess.run(cmd, capture_output=True, text=True)

        print(result.stdout)