import os

def open_pipes(num_pipes):
    pipes = []
    for _ in range(num_pipes):
        pipe = os.pipe()
        pipes.append(pipe)
    return pipes

def close_pipes(pipes):
    for pipe in pipes:
        os.close(pipe[0])
        os.close(pipe[1])

def main():
    all_child_pid = []
    commands = [["ls", "-al"], ["grep", "fork"], ["wc", "-l"]]
    pipes = open_pipes(len(commands) - 1 )

    for i, command in enumerate(commands):
        pid = os.fork()
        if pid == 0:
            if i > 0:
                os.dup2(pipes[i-1][0], 0)
            if i < len(commands) - 1:
                os.dup2(pipes[i][1], 1)
            close_pipes(pipes)
            os.execvp(command[0], command)
            os._exit()
        else:
            all_child_pid.append(pid)

    close_pipes(pipes)        
    for pid in all_child_pid:
        os.waitpid(pid, 0)
        print(f"wait {pid} successfully")
    

if __name__ == "__main__":
    main()