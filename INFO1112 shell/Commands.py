import InputParser

#built in commands

class BuiltInCommands:
    def __init__(self):
        #getting command from inputParser get_arfgs
        self.args = []
    
    def argumentisoption(self):
        argument = self.args[0]
        if argument[0] == "-":
            isoption = true
        else:
            return false
        return isoption
    
    def process_option_s(self):
        '''
        processing option s for store in var
        '''
        pass

    def process_option_P(self):
        '''
        processing option P for pwd to remove symbolic link
        '''



    def var(self):
        pass

    def pwd(self):
        pass

    def cd(self):
        pass

    def which(self):
        pass

    def exit(self):
        pass    
        