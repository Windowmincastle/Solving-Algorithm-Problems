def dfs(node, computers, v):
    v[node] = 1 # 방문처리
    # node에 연결된 a가 idx b가 value
    for idx, value in enumerate(computers[node]):
        # 1이 연결된 상태를 의미하니까 연결되어있는데 방문하지 않은 것 이라면
        # dfs 함수 호출 -> 연결되어있는 모든 노드에 대해서 방문 처리를 한다.
        if value == 1 and (not v[idx]):
            dfs(idx,computers,v)
# n -> 컴퓨터의 개수
# computers -> 연결에 대한 정보가 담긴 2차원 배열
def solution(n,computers):
    v = [0] * n # 방문 처리 리스트
    ans = 0 # 그룹의 개수
    #모든 노드를 순회
    for i in range(n):
        if not v[i]: # i번째 노드가 방문처리가 안됐다면
            # 모든 노드에 대해서 방문처리
            dfs(i,computers,v)
            #이 dfs가 실행됐다면 그룹이 1개 생성 되었다는 의미
            ans += 1
    return ans