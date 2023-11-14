import sys
sys.stdin=open('input.txt','r')
from collections import deque

def bfs(s,g):
    q = deque()
    visit = [0] * (v+1)

    q.append(s)
    visit[s] = 1

    while q:
        cur = q.popleft()

        if cur == g: #타겟노드를 찾은것.
            return visit[g] - 1 # 간선의 개수를 반환해야 하기 때문에 갱신된 거리에서 -1을 한 값을 반환 해야 한다

        for next in adj[cur]:
            if visit[next] == 0: # 0이면 미방문
                q.append(next)
                visit[next] = visit[cur] + 1 # 거리 갱신
    return 0

T = int(input())
for tc in range(1,T+1):

    v,e = map(int,input().split())
    adj = [[] for _ in range(v+1)] # 노드 개수만큼 인접 리스트, 0번은 안 쓰이니까 +1 해서 만들기
    for _ in range(e):
        a,b = map(int,input().split())
        #방향성이 없기 때문에 양방향으로 노드를 더 해주자
        adj[a].append(b)
        adj[b].append(a)

    s,g=map(int,input().split())
    ans=bfs(s,g)
    print(f'#{tc} {ans}')