from collections import deque
def bfs(si,sj,ei,ej):
    #큐 생성 , 방문 처리 테이블 생성
    q = deque()
    v = [[0] * M for _ in range(N)]
    #큐에 삽입하고 방문처리
    q.append((si,sj))
    v[si][sj] = 1

    # 큐가 빌때까지 반복
    while q:
        ci,cj = q.popleft()
        #만약 현재 큐에서 꺼낸 좌표가 종료 좌표와 같다면
        if (ci,cj) == (ei,ej):
            return v[ei][ej] #거리가 기록되어있는 방문 테이블의 value를 반환한다.

        #상,하,좌,우를 탐색한다.
        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di,cj+dj
            # ni,nj가 범위이내이고, map이 갈수있는 길 이고, 방문 테이블에서 방문을 하지 않았다면
            if 0<=ni<N and 0<=nj<M and map[ni][nj]==1 and v[ni][nj]==0:
                q.append((ni,nj)) #좌표를 큐에 넣고
                v[ni][nj] = v[ci][cj] + 1 # 거리를 갱신한다.

N,M = map(int,input().split())
map = [ list(map(int,input())) for _ in range(N)]
ans = bfs(0,0,N-1,M-1)
print(ans)