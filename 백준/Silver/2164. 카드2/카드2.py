from collections import deque
N = int(input())
arr = []

for i in range(1, N+1):
    arr.append(i)
arr = deque(arr)

while len(arr) != 1:
    arr.popleft()
    arr.rotate(-1)
print(arr[0])