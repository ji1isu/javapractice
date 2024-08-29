from input_parser import InputHandler
import os
from builtin import Builtin
import sys

var_parsed = InputHandler()
argument = var_parsed.argument

def check_valid_arg():
    if len(argument) > 1:
        raise Exception("pwd: too many arguments", file=sys.stderr)

def get_path():
    path_name = argument[0]
    if argument == "..":
        current_path = argument
    else:
        cwd = os.getcwd()
        current_path = f"{cwd}/{pathname}"
    return current_path

def change_to_path(path):
    try:
        os.chdir(path)
    except FileNotFoundError:
        print("cd: no such file or directory: ", path, file=sys.stderr)
    except NotADirectoryError:
        print("cd: not a directory: ", path,  file=sys.stderr)
    except PermissionError:
        print("cd: permission denied: ", path,  file=sys.stderr)

def main():
    check_valid_arg()
    path = get_path()
    change_to_path(path)

if __name__ == "__main__":
    main()