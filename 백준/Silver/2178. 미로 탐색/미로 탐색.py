# import sys
# sys.stdin=open('input.txt','r')

# 상 , 하 , 좌 , 우
di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]
def bfs(si,sj):
    q = []
    v = [[0] * M for _ in range(N)]

    #큐에 넣고 방문처리
    q.append((si,sj))
    v[si][sj] = 1

    while q:

        ci,cj = q.pop(0)
        # if ci == N and cj == M:
        #     return v[ci][cj]

        for i in range(4):
            ni = ci+di[i]
            nj = cj+dj[i]
            if 0 <= ni < N and 0 <= nj < M and v[ni][nj] == 0 and arr[ni][nj] == 1 :
                q.append((ni,nj))
                v[ni][nj] = v[ci][cj] + 1

    return v[N-1][M-1]

N,M = map(int,input().split())
arr = [list(map(int,input())) for _ in range(N)]
ans = bfs(0,0)
print(ans)