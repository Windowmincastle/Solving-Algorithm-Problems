# import sys
# sys.stdin = open('input.txt','r')
from collections import deque

def bfs(ci,cj):
    q = deque()
    v = [[0] * n for _ in range(n)]

    q.append((si,sj))
    v[si][sj] = 1

    while q:
        ci,cj = q.popleft()

        if arr[ci][cj] == 3:
            return v[ci][cj]

        #상 하 좌 우 탐색
        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni = ci+di
            nj = cj+dj
            if 0<= ni < n and 0 <= nj <n and v[ni][nj]== 0 and arr[ni][nj] != 1:
                q.append((ni,nj))
                v[ni][nj] = 1
    return 0

T = 10
for tc in range(1,T+1):

    _ = int(input())
    n = 16
    arr = [ list(map(int,input())) for _ in range(n)]
    si,sj = 1,1
    ans = bfs(si,sj)
    print(f'#{tc} {ans}')