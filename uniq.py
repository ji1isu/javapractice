import sys

def sort_stdin(inputs_ls):
    unique_ls = []

    for i in range(len(inputs_ls)):
        if inputs_ls[i] not in unique_ls:
            unique_ls.append(inputs_ls[i])
    for line in unique_ls:
        print(line)

def read_from_input():
    inputs_ls = []
    try:
        while True:
            new_input = input()
            inputs_ls.append(new_input)
    except EOFError:
        return inputs_ls

def read_from_file():
    inputs_ls = []
    filename = sys.argv[1]
    try:
        with open(filename, 'r') as f:
            inputs_ls = [line.strip() for line in f]
    except FileNotFoundError:
        print(f"Error: '{filename}' cannot be found to stderr")
        exit(0)
    return inputs_ls


def main(args: list[str]) -> None:
    if len(args) > 1:
        print("Error: accepts only 1 optional argument to stderr")
        exit(0)
    elif len(args) == 0:
        inputs_ls = read_from_input()
    elif len(args) == 1:
        inputs_ls = read_from_file()
    sort_stdin(inputs_ls)

if __name__ == "__main__":
    main(sys.argv[1:])