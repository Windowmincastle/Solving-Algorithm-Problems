
# 터널의 종류에 따른 좌표 이동 정의.
p = [[0,0,0,0],
     [1,1,1,1],
     [1,1,0,0],
     [0,0,1,1],
     [1,0,0,1],
     [0,1,0,1],
     [0,1,1,0],
     [1,0,1,0]]

opp = [1,0,3,2]

di, dj = [-1,1,0,0],[0,0,-1,1]

def bfs(si,sj):
    q = [] #큐
    v = [[0] * M for _ in range(N)]#방문테이블
    ans = 0 #정답처리 변수

    q.append((si,sj)) # 삽입
    v[si][sj] = 1 # 방문 처리
    ans += 1 # 카운트 1

    while q: # 큐에 데이터가 있는동안

        ci,cj = q.pop(0)
        #꺼냇으면 정답 처리 여기서 하자
        if v[ci][cj] == L:
            return ans

        # 4방향, 범위내, 조건(현위치 - 이동할 위치 모두 파이프 있는경우)
        for dr in range(4):
            ni = ci+di[dr]
            nj = cj+dj[dr]
            if 0 <= ni < N and 0 <= nj < M and v[ni][nj] == 0 and p[arr[ci][cj]][dr] == 1 and p[arr[ni][nj]][
                opp[dr]] == 1:
                q.append((ni, nj))
                v[ni][nj] = v[ci][cj] + 1
                ans += 1
    return ans  # 가능한 위치보다 더 긴 시간을 준 경우..

T = int(input())
for tc in range(1,T+1):
    #세로 크기, 가로 크기 , 세로 위치 ,가로 위치 , 시간
    N,M,R,C,L = map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(N)]

    ans = bfs(R,C)
    print(f'#{tc} {ans}')