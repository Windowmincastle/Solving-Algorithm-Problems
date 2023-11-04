'''
SWEA D4 보급로
문제 링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD

'''
import sys
from collections import deque

sys.stdin = open("input.txt","r")

INF = 10000 # 100 x 100 크기
def bfs(si,sj,ei,ej): # start i,j // end i,j
    q = deque() # 큐 생성
    v = [[INF]*N for _ in range(N)] # 갱신 테이블 생성

    q.append((si,sj)) # 시작 좌표 삽입
    v[si][sj] = arr[si][sj] # 갱신 테이블의 start 초기화

    while q: #큐가 빌때까지
        ci,cj = q.popleft() # 큐에서 꺼내서 current i, current j 좌표 초기화
                        #상 ,하, 좌, 우 순환
        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni = ci + di # next_i 를 현재 위치 + 상,하,좌,우
            nj = cj + dj # next_j 를 현재 위치 + 상,하,좌,우

                # 4방향 , 범위를 벗어나지않고 and 이동할 위치 비용이 더 적은 경우
            if 0 <= ni < N and 0 <= nj < N and v[ni][nj] > v[ci][cj] + arr[ni][nj]:
                q.append((ni,nj)) # next_i,j의 좌표를 q에 삽입
                v[ni][nj] = v[ci][cj] + arr[ni][nj]
                # v 테이블에 다음 좌표 값을 v_테이블 현재 좌표 값 + arr 다음 좌표 값으로 초기화
    return v[ei][ej]

T = int(input())
for tc in range(1,T+1):

    N = int(input())
    arr = [list(map(int,input())) for _ in range(N)]

    ans = bfs(0,0,N-1,N-1)
    print(f"#{tc} {ans}")