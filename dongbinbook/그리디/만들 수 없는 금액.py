'''
틀림

'''
n = int(input())
lst = list(map(int,input().split()))

target = 1

for i in lst:

    if target < i :
        break
    target += i

print(target)