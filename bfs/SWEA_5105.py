'''
SWEA D3 5105 미로의 거리
https://swexpertacademy.com/main/learn/course/lectureProblemViewer.do
'''
from collections import deque

import sys
sys.stdin = open('input.txt','r')

#상 , 하 , 좌 , 우
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(si,sj):
    q = deque() # 1 . 큐 생성
    v = [[0] * N for _ in range(N)] # 2. 방문 기록 행렬 생성

    q.append((si,sj)) # 3. 큐에 초기 데이터 넣기 , 이렇게 튜플로 넣어도 된다
    v[si][sj] = 1 # 방문 처리

    while q:
        ci,cj = q.popleft() # 튜플로 큐에 넣고 변수 2개로 받으면 맵핑된다
        #정답 처리는 빼낸 다음에 하자
        if arr[ci][cj] == 3: #목적지인지 값으로 알수있다.
            return v[ci][cj]-2 # 거리기록을 갱신한 자리의 값을 리턴

        for i in range(4):
            ni = ci + dx[i]
            nj = cj + dy[i]
            # 4방향 , 범위이내 , 벽이아닐때(1) , 미방문 조건일시
            if 0 <= ni < N and 0 <= nj < N and v[ni][nj] ==0 and arr[ni][nj] != 1 :
                q.append((ni,nj))
                v[ni][nj] = v[ci][cj] + 1
    return 0 # 목적지에 도달 못 한 경우

T = int(input())
for tc in range(1,T+1):

    N = int(input())
    arr = [list(map(int,input())) for _ in range(N)]

    #시작 좌표를 찾아야 한다.
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 2:
               si, sj = i, j

    ans = bfs(si,sj)
    print(f'#{tc} {ans}')