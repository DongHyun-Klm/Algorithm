N = int(input())
def star(N):
    if N // 3 == 1:
        return ['*'*3, '*'+' '+'*', '*'*3]
    arr = star(N//3)
    stars = []

    for i in arr:
        stars.append(i*3)
    for i in arr:
        stars.append(i + ' '*(N//3) + i)
    for i in arr:
        stars.append(i * 3)
    return stars
print('\n'.join(star(N)))