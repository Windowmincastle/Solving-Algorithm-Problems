from itertools import combinations

N,M = map(int,input().split())
lst = list(map(int,input().split()))
mv = 0
for value in combinations(lst,3):

    if sum(value) <= M:
        mv = max(mv,sum(value))

print(mv)