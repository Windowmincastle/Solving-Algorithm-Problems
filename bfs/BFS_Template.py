'''
https://swexpertacademy.com/main/learn/course/lectureProblemViewer.do
SWEA 5102 D2 노드의 거리
bfs 연습
'''
from collections import deque
import sys
sys.stdin = open("input.txt","r")

def bfs(s,e):
    #[1] 큐 , v[] 방문 거리 갱신 리스트 , 생성 및 필요 변수(플래그) 선언
    q = []
    v = [0] *(V+1)#정점개수만큼 만들자

    #[2] q에 초기 데이터(들) 삽입, v[] 표시
    q.append(s) # s 정점 삽입, 초기데이터는 당연히 시작점 이겟지?
    v[s]=1 # 방문처리할때 시작을 1로 표시 큐에 초기데이터를 방문했으니 당연히 방문처리를 한다.

    while q: #큐가 빌때까지
        current = q.pop(0) # 인자로 0 주면 앞쪽에서 꺼냄 , 큐에서 꺼내서 current에 저장
        #정답처리는 가능하면 이곳에서 한다.

        if current == e: # 현재 노드가 마지막 노드라면 ? 찾은거다.
            return v[e]-1 # 아래 for문에서 지금까지 갱신해왔던
        #방문거리갱신리스트의 v[e]-1의 값을 return 한다.

        for next in adj[current]: # 연결된 노드
            if v[next] == 0 : # 연결되어있는데 아직 방문하지않은 노드라면
                q.append(next)
                v[next] = v[current]+1 #거리 갱신
    #큐를 다 돌앗는데도 목적지를 방문하지 못 한 경우
    return 0

T = int(input())
for tc in range(1,T+1):

    V,E = map(int,input().split())
    adj =[[] for _ in range(V+1)] # 인접 리스트를 만들자

    for _ in range(E):
        s,e = map(int,input().split())
        adj[s].append(e) #방향성이 없는 경우는 이런 식 으로 인접 리스트를 구성해줘야한다
        adj[e].append(s)

    S,G = map(int,input().split())

    ans = bfs(S,G)

    print(f"#{tc} {ans}")