N = int(input())
A = N % 5
B = N // 5
cnt = 0
if A == 0:
    print(B)
elif A == 3:
    print(B+1)
else: #A = 1,2,4
    for i in range(B-1,-1,-1):
        C = (N - 5*i) % 3
        if C == 0:
            print(((N - 5*i) // 3)+i)
            cnt += 1
            break
    if cnt == 0:
        print(-1)