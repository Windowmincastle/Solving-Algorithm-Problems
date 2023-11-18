from itertools import combinations
import sys
sys.stdin=open('input.txt','r')
T = int(input())
for tc in range(1,T+1):

    n,k = map(int,input().split())
    lst = list(map(int,input().split()))
    tmp = []
    ans = 0
    for i in range(len(lst)):

        result = list(combinations(lst,i))

        for j in range(len(result)):

            if sum(result[i]) == k:
                ans += 1

    print(f'#{tc} {ans}')