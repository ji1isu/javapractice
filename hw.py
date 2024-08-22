import sys

def read_file_to_list(filename):
    all_names = []
    with open(filename, 'r') as f:
        for line in f:
            all_names.append(line.strip())
    return all_names
    
def sort_by_order(all_names: list[str]):
    all_names = sorted(all_names, key=str.lower)
    unique_names = []
    previous_names = None
    for name in all_names:
        if name.lower() != previous_names: 
            unique_names.append(name)
            previous_names = name.lower()
    return unique_names

def print_all(all_names):
    for word in all_names:
        print(word)

def from_file(_file):
    names = read_file_to_list(_file)
    sort_by_order(names)
    print_all(names)

def main(args: list[str]) -> None:
    if len(sys.argv[1:]) == 1:
        _file = sys.argv[1]
        from_file(_file)
    elif len(sys.argv[1:]) > 1:
        print("Error: accepts only 1 optional argument")


if __name__ == "__main__":
    main(sys.argv[1:])