from collections import deque
# import sys
# sys.stdin=open('input.txt','r')

def bfs(si,sj):
    q = deque()
    ans = []

    q.append((si,sj))
    v[si][sj] = 1
    ans.append(arr[si][sj])

    while q:
        ci,cj = q.popleft()

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)) :
            ni,nj = ci+di,cj+dj

            if 0<=ni<n and 0<=nj<n and v[ni][nj]==0 and (abs(arr[ci][cj]-arr[ni][nj]) == 1):
                q.append((ni,nj))
                v[ni][nj] = 1
                ans.append((arr[ni][nj])) # arr[ni][nj] 괄호 하나 안 하나 상관 없다
    return min(ans),len(ans)

T=int(input())
for tc in range(1,T+1):

    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]

    v = [[0]*n for _ in range(n)]

    num,cnt = n*n , 0

    for i in range(n):
        for j in range(n):

            if v[i][j] == 0 :
                temp_num, temp_cnt = bfs(i,j)
                # cnt가 temp_cnt보다 작다면 또는
                if cnt < temp_cnt or (cnt==temp_cnt and num > temp_num):
                    num,cnt =temp_num,temp_cnt
    print(f'#{tc} {num} {cnt}')