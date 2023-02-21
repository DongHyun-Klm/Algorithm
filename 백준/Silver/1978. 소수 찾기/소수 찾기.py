N = int(input())
number = list(map(int, input().split()))
sosu = 0
for i in range(N):
    cnt = 0
    for j in range(1,number[i]):
        if number[i] == 1:
            pass
        elif number[i] % j == 0:
            cnt += 1
    if cnt == 1:
        sosu += 1
print(sosu)