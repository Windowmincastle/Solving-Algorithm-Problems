from collections import deque
import sys
sys.stdin = open('input.txt',"r")

N,M = map(int,input().split())
arr = [list(map(int,input())) for _ in range (N)]

#상 , 하 , 좌 , 우
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(x,y):
    #함수 내부에서 deque 자료형 생성
    queue = deque()
    queue.append((x,y)) #튜플로 넣네?

    while queue:
        x,y = queue.popleft() # 좌표값을 설정할땐 튜플로 하는 것이 유리해보인다.

        for i in range(4): #상하좌우를 탐색하니까 4번 반복
            nx = x + dx[i] # nx가 조이스틱 이다 생각 현재 x,y의 자리에서 상 하 좌 우 값 더해서 탐색
            ny = y + dy[i] # ny가 조이 스틱이다 라고 생각
            #공간을 벗어난 경우 무시
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue# 공간을 벗어나면 다시 상하좌우 진행
            #괴물인 경우 무시
            if arr[nx][ny] == 0:
                continue#괴물인경우 다시 상하좌우 진행
            # 괴물 무시 , 공간 벗어난 경우 무시 , 즉 아래 if문은 갈수있는 길인 경우
            if arr[nx][ny] == 1:#괴물도 아니고 벽도 아니면 진행
                arr[nx][ny] = arr[x][y] + 1 # 거리 기록
                queue.append((nx,ny)) # 기록한 노드의 위치를 queue에 삽입
    return arr[N-1][M-1] #n x m 까지의 최단 거리 반환

print(bfs(0,0))#시작 좌표를 입력

