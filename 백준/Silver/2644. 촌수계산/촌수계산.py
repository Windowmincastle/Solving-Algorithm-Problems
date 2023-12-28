def bfs(s,e):
    # 큐 생성
    q = []
    # 방문 처리할 리스트 생성
    v = [0] * (N+1)
    # 큐에 탐색을 시작할 노드 s를 삽입.
    q.append(s) # 삽입
    v[s] = 1 # 방문처리

    while q:
        # 탐색할 현재 노드 번호를 cur에 할당
        cur = q.pop(0)
        if cur == e:
            return v[e]-1 # 방문처리를 시작할때 1부터 기록했으므로 -1 한다.
        # adj[cur] --> 노드 --> 연결된 노드를 꺼낸다 --> next
        for next in adj[cur]:
            #미방문이라면? -> v[next]가 0이라면?
            if not v[next]:
                q.append(next)
                # 뎁스마다 1씩 더해주며 기록한다.
                v[next] = v[cur] +1
    #관계를 찾지 못 했다면 -1
    return -1

N = int(input())
#촌수를 계산해야 하는 서로 다른 두 사람의 번호
start , end = map(int,input().split())
# 부모와 자식들간의 관계를 몇 개 줄건지?
M = int(input())
#인접리스트 선언
adj = [[] for _ in range(N+1)]
# p는 c의 부모
for _ in range(M):
    # 부모와 자식 관계로 입력받기
    parent, child = map(int,input().split())
    # 양방향 노드이기 때문에 둘다 추가해줘야한다.
    adj[parent].append(child)
    adj[child].append(parent)

ans = bfs(start,end)
print(ans)