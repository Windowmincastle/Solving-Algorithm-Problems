'''
SWEA D4 Ladder1

방향을 설정해서 큐로 풀어보려고 했는데 실패했고 정답을 봤다.
매우 간결한 방법이 있었다. 다시 풀어볼 것 
힌트 - if elif else를 사용해서 좌,우,상단을 체크
왔던 길 막기, 좌표 value 변경. 사다리 맵 패딩 - 11월 7일 오전 1시 43분

'''
from collections import deque
import sys
sys.stdin = open("input.txt",'r')
T = 10
for tc in range(1,T+1):
    _ = int(input()) # tc 사용 X
    N = 100 # N 100으로 고정
    # 사다리 2차원 리스트 , 0으로 패딩
    arr = [ [0] + list(map(int,input().split())) + [0] for _ in range(N)] # 100 x 100 사다리

    # 도착 지점 찾기
    ci = 99
    for j in range(N):
        if arr[ci][j] == 2:
            cj = j
            break

    while ci > 0: # 99행에서 -1씩 하면서 출발지로 가기 때문에 행이 -1 씩
        #[1] 좌우 , 위 길 체크
        arr[ci][cj] = 0
# 왔던 길을 막기, 막지 않으면 좌로 이동하거나 우로 이동하고 다시 길을 탐색할때 좌우가 길 이라서 오류가 생긴다.
        if arr[ci][cj-1] == 1 : # 좌측이 길이라면
            cj -= 1 # 좌측 이동
        elif arr[ci][cj+1] == 1: # 우측이 길이라면
            cj += 1
        else: # 좌,우 모두 길이 아니고 위로간다면
            ci -= 1

    print(f'#{tc} {cj-1}')# 패딩해줬으니 j열 변경에 주의하고 -1 해야함