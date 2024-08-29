import sys
import os
i = 0
print(i)

pid = os.fork()
if pid == 0:
    while i<3:
        i += 1
        print("child", i)
elif pid > 0:
    os.wait()
    while i < 3:
        i +=1
        print("parent", i)
else:
    print("error!")
    sys.exit(1)