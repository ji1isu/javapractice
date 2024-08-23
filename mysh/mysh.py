import os
import json


CMD_ALL = {
    "exit": builtin_exit,
    "eg": builtin_example
}

# make file reader . you need this to access prompt and intialise shell
def read_json_file(file_path):
    with open(file_path, 'r', encoding = 'utf-8') as f:
        data = json.load(f)
        return data
        #json.load()? will transer file data to the shell

def builtin_exit():
    exit(0)

def builtin_example():
    print("this is an example built in")



#have a command table that you can add commands to(build in)

#
# make mySh class that:
# executes functions using os.system(cmd)
#adds to table
#

# main looping /main 
#get commands
#if mysh is a built in command
# execute and cintinue
# itherwise mys.cmd_exec if in os