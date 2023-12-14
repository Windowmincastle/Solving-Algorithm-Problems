from itertools import combinations

lst = [int(input()) for _ in range(9)]

for value in combinations(lst,7):

    if sum(value) == 100:

        for j in sorted(value):
            print(j)
        break