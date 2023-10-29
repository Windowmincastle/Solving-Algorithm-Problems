arr = [list(map(int,input().split())) for _ in range(9) ]
temp = 0
for lst in arr:
    temp += sum(lst)

print(temp)