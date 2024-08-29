from input_parser import InputHandler
import os
from builtin import Builtin
import string

valid_characters = list(string.ascii_letters + string.digits + "_")

var_parsed = InputHandler()
argument = var_parsed.argument
option = []

def is_option():
    for arg in argument:
        if arg[0] == "-":
            option.append(arg)
            return True
    return False

def is_valid_option():
    if len(option) >=1:
        if var_parsed.option[0] == ["-s"]:
            return True
        print("var: invalid option: ", option[0],  file=sys.stderr)
        # exit
    return False

def s_option():
    if is_valid_option():
        pid = os.fork()
        if pid == 0:
            new_input = argument[1:]
            Builtin.exec(self, new_input[0])
            # use the input to execute/search for function

            # returned_stdout = # a function from builtin that executes based on call
            os._exit(0) 
        else:
            os.wait()
        # return returned_stdout
    else:
        return None

def return_value():
    if is_valid_option():
        return s_option()
    return argument[1:]
    
def has_all_valid():
    for char in var_parsed._input:
        if char not in valid_characters:
            print("var: invalid characters for variable ", argument[0],  file=sys.stderr)
            #exit
    pass

def assign_var():
    value = return_value()
    os.environ[argument[0]] = value

def main():
    is_option()
    has_all_valid()
    if argument != 2:
        print("var: expected 2 arguments, got ", len(arguments),  file=sys.stderr)
        # exit
    assign_var()   

if __name__ == "__main__":
    main()