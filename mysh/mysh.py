import os
import json
import subprocess

from builtin import Builtin

def read_json_file(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        data = json.load(f)
        return data

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

        #other errors:
        # no file/directory
        #is directory
        #permission denied
