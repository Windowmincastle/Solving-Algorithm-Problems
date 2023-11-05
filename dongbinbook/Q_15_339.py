'''
Q_15_339페이지
특정 거리의 도시 찾기

모든 간선의 비용이 동일할 때는 BFS를 이용하여 최단거리를 찾을 수 있다.
"모든 도로의 거리는 1' 이라는 조건 덕분에 BFS를 이용해서 간단히 해결 가능.

시작 도시를 큐에 넣고 시작 도시와 연결되어 있는 도시를 next_node로 받아서
방문처리 하면서 거리를 갱신 -> 큐에 넣기

다음 도시도 반복
'''
from collections import deque

N,M,K,X = map(int,input().split())
#도시와 도로 정보를 입력받을 graph를 만들자.
graph = [[] for _ in range(N+1)]

#모든 도로 정보를 입력받아서 graph에 저장하자
for _ in range(M):
    a , b= map(int,input().split())
    graph[a].append(b)

#최단거리를 기록할 테이블을 -1로 초기화 해놓기.
distance = [-1] * (N+1)
#시작 도시 X 는 거리가 0 이니까 0으로 초기화 해놓기
distance[X] = 0

#큐에다가 리스트를 넣어서 리스트를 뺀다.
q = deque([X])

while q:

    # 큐에 들어가있는 현재 노드 번호를 cuurent_city에 뺀다.
    current_city = q.popleft()
    # 다음 도시를 순차적으로 next_city에 저장하고, graph[1]번 도시에 연결되어있는 도시들을 next_city에 순차적으로 가져오자
    for next_city in graph[current_city]:
        # graph[cuurent_city] = graph[1]번 도시에 연결된 도시가 방문하지 않은 곳 이라면?
        if distance[next_city] == -1: # -1로 구분
            # 최단 거리 갱신
            distance[next_city] = distance[current_city] + 1 # 현재 도시에서 거리가 1차이 나니까 현재도시 + 1
            #40라인 거리 정보를 갱신하는 것 이다.
            q.append(next_city) # 큐에 next_city를 넣는다.

check = False
for i in range(1, N+1):
    if distance[i] == K :
        print(i)
        check = True

if check == False:
    print(-1)