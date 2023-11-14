'''
SWEA D4 미로1
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14vXUqAGMCFAYD
'''
from collections import deque

import sys
sys.stdin = open('input.txt','r')

di = [-1,1,0,0]
dj = [0,0,-1,1]

def bfs(si,sj):

    q = deque()
    v = [[False] * N for _ in range(N)] # 16 * 16 방문 테이블 만들기.

    q.append((si, sj))  # 3. 큐에 초기 데이터 넣기 , 이렇게 튜플로 넣어도 된다
    v[si][sj] = True # 방문 처리

    while q:
        ci,cj = q.popleft() # 현재 좌표 꺼내서 ci,cj 삽입
        if arr[ci][cj] == 3:
            return 1

        for i in range(4):
            ni = ci + di[i]
            nj = cj + dj[i]
            if 0 <= ni < N and 0 <= nj < N and v[ni][nj]==False and arr[ni][nj]!=1:
                q.append((ni,nj))
                v[ni][nj] = True
    return 0

T=10
for tc in range(1,T+1):
    _ = int(input())
    N = 16

    arr = [list(map(int,input())) for _ in range(N)] # spilt 조심

    si,sj = 1,1

    ans = bfs(si,sj)

    print(f'#{tc} {ans}')