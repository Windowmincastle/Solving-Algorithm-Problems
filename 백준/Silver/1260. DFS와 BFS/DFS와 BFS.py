def dfs(current):
    ans_dfs.append(current)
    v[current] = 1

    #현재 노드와 연결된 정점을 불러와서
    for next in adj[current]: # 탐색한다.
        if v[next] == 0:
            #여기서 dfs를 바로 재귀적으로 호출하기 때문에
            # BFS 탐색이 아니라 DFS 탐색으로 된다
            # why? bfs라면 이 반복문에서 current 노드와
            # 연결되어있는 모든 노드들을 q에 append하기 때문이다.
            dfs(next)

def bfs(s):
    q = []
    q.append(s)
    ans_bfs.append(s)
    v[s] = 1
    while q:
        current = q.pop(0)
        # dfs랑 비교해보라 큐에서 순차적으로 뽑기 때문에
        # 방문하지 않은 노드라면 바로 dfs를 재귀 호출하는
        # dfs와 동작원리가 다르다.
        for next in adj[current]:
            if v[next] == 0:
                q.append(next)
                ans_bfs.append(next)
                v[next] = 1


# N -> 노드 개수 , M -> 간선 정보 , V -> 시작 정점
N,M,V = map(int,input().split())
adj = [[] for _ in range(N+1)] # 노드가 N개인데 0번은 안 쓰니까 +1개 하자

for _ in range(M):
    parent , child = map(int,input().split())
    # 간선 양방향 처리
    adj[parent].append(child)
    adj[child].append(parent)

# 정점 번호가 작은 것 부터 방문하기 때문에 sort 해야함
# 1번 노드부터 N번 노드까지
for i in range(1,N+1):
    adj[i].sort()

v = [0] * (N+1)
ans_dfs = []
dfs(V)

v = [0] * (N+1)
ans_bfs = []
bfs(V)

print(*ans_dfs)
print(*ans_bfs)