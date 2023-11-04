from collections import deque

def bfs(graph,start,visited):

    # 덱 자료형 생성 start=시작노드 넣기
    queue = deque([start])
    # 방문한 노드 방문 처리
    visited[start] = True

    #큐가 빌 때 까지 반복
    while queue:
        v = queue.popleft() # 선입선출로 뺀다
        print(v,end=' ') # 출력

        for i in graph[v]: # 현재 노드의 연결 리스트 정보를 순차적으로 접근
            if not visited[i]: # 만약 v 노드와 근접한 노드 중 방문하지 않은 곳이 있다면?
                queue.append(i) # 큐에 넣고
                visited[i] = True # 방문 처리

graph = [ #리스트 자료형, 연결리스트로 노드의 연결 정보를 표현
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]

#각 노드가 방문된 정보를 리스트 자료형으로 표현
visited = [False] * 9
# 2차원 배열, 시작노드, 방문 정보 기록 리스트
bfs(graph,1,visited)