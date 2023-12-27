# import sys
# sys.stdin=open('input.txt','r')

def bfs(si,sj):
    #집의 수
    count = 0
    q = []
    v = [[0]*N for _ in range(N)]

    q.append((si,sj))
    v[si][sj] = 1 # 방문처리
    count += 1

    while q:

        ci,cj = q.pop(0)

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di,cj+dj
            if 0<=ni<N and 0<=nj<N and map[ni][nj] == 1 and v[ni][nj] == 0:
                q.append((ni,nj))
                count += 1
                map[ni][nj] = 2
                v[ni][nj] = 1

    return count

N = int(input())
map = [list(map(int,input())) for _ in range(N)]
lst = []
num = cnt = 0

for i in range(N):
    for j in range(N):
        if map[i][j] == 1:
            cnt = bfs(i,j)
            num += 1
            lst.append(cnt)

print(num)
lst.sort()
for i in lst:
    print(i)