import sys
sys.stdin=open('input.txt','r')

di=[1,-1,0,0]
dj=[0,0,-1,1]
def bfs(si,sj):
    q=[]
    v=[[0]*n for _ in range(n)]
    q.append((si,sj))
    v[si][sj] = 1

    while q:
        ci,cj = q.pop(0)

        if arr[ci][cj] == 3:
            return v[ci][cj] - 2

        for i in range(4):
            ni,nj = ci+di[i] , cj+dj[i]
            if 0 <= ni < n and 0<= nj < n and arr[ni][nj] != 1 and v[ni][nj] == 0:
                q.append((ni,nj))
                v[ni][nj] = v[ci][cj] + 1

    return 0
T = int(input())
for tc in range(1,T+1):

    n = int(input())
    arr = [list(map(int,input())) for _ in range(n)]

    si,sj=0,0
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 2:
                si,sj=i,j

    ans = bfs(si,sj)
    print(f'#{tc} {ans}')