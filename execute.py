import subprocess

result = subprocess.run(['grep'], capture_output=True, text=True)

print(result.stdout)
print(result.stderr)
print("abc\"def\"")
