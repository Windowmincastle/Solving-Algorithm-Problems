import sys
sys.stdin=open('input.txt','r')

def bfs(si, sj):
    # [1] q, v, ans[] 생성
    q = []
    ans = []

    # [2] 초기값 삽입 등 단위작업
    q.append((si,sj))
    v[si][sj]=1
    ans.append(arr[si][sj])     # 정답관련 처리

    while q:
        ci,cj = q.pop(0)
        # 4방향, 범위내, 미방문, 1차이나는 위치면..
        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di, cj+dj
            if 0<=ni<N and 0<=nj<N and v[ni][nj]==0 and (abs(arr[ci][cj]-arr[ni][nj])==1):
                q.append((ni,nj))
                v[ni][nj]=1
                ans.append((arr[ni][nj]))
    return min(ans), len(ans)   # 제일 작은 번호, 개수를 리턴
        # 의미 min = 시작 지점 , ans = 몇번 방을 이동햇는지
T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    v = [[0]*N for _ in range(N)]
    num, cnt = N*N, 0
    for i in range(N):
        for j in range(N):
            if v[i][j]==0:  # 방문안한 숫자
                tnum, tcnt = bfs(i,j)
                if cnt<tcnt or (cnt==tcnt and num>tnum):
                    num, cnt = tnum, tcnt
    print(f'#{test_case} {num} {cnt}')