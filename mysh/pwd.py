from input_parser import InputHandler
import os
from builtin import Builtin

var_parsed = InputHandler()
argument = var_parsed.argument

option = []

def is_option():
    if len(arguments) > 1:
        raise Exception("pwd: not expecting any arguments", file=stderr)
    for arg in argument:
        if arg[0] == "-":
            option.append(arg)
            return True
    return False

def is_valid_option():
    if len(option) >=1:
        if var_parsed.option[0] == ["-P"]:
            return True
       raise Exception("pwd: invalid option: ", option[0], file = stderr)
        # exit
    return False

def P_option():
    if is_valid_option():
        #resolve symbolic links
    else:
        pass

def main():
    P_option()
    print(os.getcwd())

if __init__ == "__main__":
    main()