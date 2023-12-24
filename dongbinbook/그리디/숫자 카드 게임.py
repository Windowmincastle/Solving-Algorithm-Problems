'''
이코테 with 파이썬
96페이지 숫자 카드게임

맞춤
'''
import sys
sys.stdin=open('input.txt','r')

N,M = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]

tmp = []
for i in range(N):

    tmp.append(min(arr[i]))

ans = max(tmp)
print(ans)

