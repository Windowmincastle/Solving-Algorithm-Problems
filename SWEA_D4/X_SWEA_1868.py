from collections import deque
# 8방향
dr = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]
def bfs(ni, nj):
    # 특정 위치 주변에 지뢰가 몇 개 있는지를 확인하는 함수
    tmp = 0
    for d in dr:
        dx, dy = ni + d[0], nj + d[1]
        # 주변 8방향을 검사
        if 0 <= dx < N and 0 <= dy < N and arr[dx][dy] == '*':
            # 지뢰 '*'를 발견하면 지뢰 개수 증가
            tmp += 1

    arr[ni][nj] = tmp  # 해당 위치에 지뢰 개수를 업데이트
def check(nr, nc): #최소 몇 번을 클릭해야 하는지 알면되기 때문에 44행의 중첩 반복문에서
    # 클릭한 지점이 0일때 주변에 있는 모든 0인 지점을 카운트해주고 모든 지점을 '*'로 바꾸면 된다
    Q = deque()
    Q.append([nr, nc])
    arr[nr][nc] = '*'  # 클릭한 지점을 '*'로 표시
    while Q:
        ni, nj = Q.popleft() #큐에서 뽑아서
        for d in dr: # 8방향 처리
            dx, dy = ni + d[0], nj + d[1]
            if 0 <= dx < N and 0 <= dy < N:
                if arr[dx][dy] == 0:
                    # 주변에 0이면 '*'로 바꾸고 큐에 추가
                    arr[dx][dy] = '*'
                    Q.append([dx, dy])
                elif arr[dx][dy] != '*':
                    # 주변에 이미 '*'이 아닌 값이면 '*'로 변경
                    arr[dx][dy] = '*'

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [list(input()) for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if arr[i][j] == '.':
                bfs(i, j)  # '.'인 지점에 대해 주변 지뢰 개수를 계산

    cnt = 0 # 한번의 클릭으로 주변이 다 0이 되긴하나 클릭이기 때문에 카운트 한다.
    for i in range(N): # 44행
        for j in range(N):
            if arr[i][j] == 0:
                cnt += 1
                check(i, j)  # 0인 지점을 클릭하고 연쇄적으로 처리
    
    # 남은 숫자 갯수 세기
    for i in range(N):
        for j in range(N):
            if arr[i][j] != '*':
                cnt += 1# *을 제외한 클릭 횟수 카운트

    print(f'#{tc} {cnt}')
