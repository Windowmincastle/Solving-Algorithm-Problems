di=[-1,1,0,0]
dj=[0,0,-1,1]

def bfs(si,sj):
    q = [] # 큐 만들고
    v = [[0] * n for _ in range(n)] #방문행렬만들고

    q.append((si,sj)) #큐에넣고 시작지점을
    v[si][sj] = 1#그 지점을 방문처리하고

    while q:
        ci,cj = q.pop(0)

        if arr[ci][cj] == 3:
            return v[ci][cj]-2

T = int(input())
for tc in range(1,T+1):

    n = int(input())
    arr = [list(map(int,input())) for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if arr[i][j] == 2:
                si , sj = i ,j

    ans = bfs(si,sj)
    print(f'#{tc} {ans}')