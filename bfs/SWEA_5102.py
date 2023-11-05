'''
https://swexpertacademy.com/main/learn/course/lectureProblemViewer.do
SWEA 5102 D2 노드의 거리
bfs 연습
'''
from collections import deque
import sys
sys.stdin = open("input.txt","r")

def bfs(s,e):

    q = deque()
    v = [0] * (V+1)

    q.append(s) # q에다가 시작 정점 삽입.
    v[s] = 1 # 삽입 햇으니 방문처리

    while q:
        current = q.popleft()
        if current == e: # end를 만낫으니깐
            return v[e] - 1

        for next in adj[current]: # 연결된 노드
            if v[next] == 0 : #미방문노드
                q.append(next) #큐에 넣고
                v[next] = v[current] + 1
    return 0 #목적지를 방문하지 못 한 경우

T = int(input())
for tc in range(1,T+1):

    V , E = map(int,input().split())
    adj = [[] for _ in range(V+1)]
    for _ in range(E):
        s , e = map(int,input().split())
        adj[s].append(e)
        adj[e].append(s)
    S,G = map(int,input().split())

    ans = bfs(S,G)
    print(f'#{tc} {ans}')
