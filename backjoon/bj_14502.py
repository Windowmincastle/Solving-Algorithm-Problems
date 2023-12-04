'''
백준 14502번 문제 유형 BFS
골드 4

핵심 :벽을 어떤 기준으로 세워야 안전 구역이 최대가 되는가?

'''
def makeWall(cnt):
    if cnt == 3:
        bfs()
        return
    # 이 과정을 통해서 벽을 세우는 모든 경우의 수를 검토한다.

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:  # 벽을 세우기 위한 조건
                graph[i][j] = 1  # 벽을 세운다
                makeWall(cnt + 1)  # 다시 두 번째 벽을 세우기 위한 함수 호출
                graph[i][j] = 0  # 다시 벽을 허무는 과정 (백트래킹)
def bfs():
    q = deque()
    # 원래의 grpah를 유지 시킨다
    tmp_graph = copy.deepcopy(graph)

    # 모든 바이러스 좌표를 반복문으로 큐에 넣는다
    for i in range(n):
        for j in range(m):
            if tmp_graph[i][j] == 2:  # 현재 좌표가 2인 경우
                q.append((i, j))  # 현재 좌표를 큐에 삽입

    # 바이러스 퍼트리기 시작
    while q:
        i, j = q.popleft()
        for i in range(4):
            ni = i + di[i]
            nj = j = dj[j]
            # 범위 체크
            if 0 <= ni < n and 0 <= nj < m:
                if tmp_graph[ni][nj] == 0:  # 감염이 안된 곳 이라면
                    tmp_graph[ni][nj] = 2  # 감염을 시킨다.
                    q.append((ni, nj))  # 감염 좌표 삽입.
    global ans
    cnt = 0

    for i in range(n):
        cnt += tmp_graph[i].count(0)

    ans = max(ans, cnt)

import copy
from collections import deque

n,m = map(int,input().split())
graph = [] # 빈 맵
ans = 0

#상하좌우 방향 설정
di=[0,0,1,-1]
dj=[1,-1,0,0]

for i in range(n):
    graph.append(list(map(int,input().split())))

makeWall(0) # 벽 세우기 호출
print(ans) #
