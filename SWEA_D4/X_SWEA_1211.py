'''
SWEA D4 Ladder2
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14BgD6AEECFAYh
1차 실패 - 날짜, 11월 10일

'''
import sys
sys.stdin = open('input.txt','r')

# 하, 좌, 우 구분
# 0, sj = -1, 1
T = 10
for tc in range(1,T+1):

    _ = int(input())
    N = 100
    minvalue = N * N
    arr = [[0]+list(map(int,input().split()))+[0] for _ in range(N)]

    for sj in range(1,N+1):
        if arr[0][sj] == 0:
            continue
        cj = sj
        cnt = ci = dr = 0
        while ci < N-1:
            cnt += 1
            if dr == 0 : #현재 방향 설정이 0으로 되어있다면
                ci += 1
                #아래로 한칸 내린 뒤 좌우를 살펴봐야지
                if arr[ci][cj-1]==1: # 좌측에 길이 있으면
                    dr = -1 # 방향을 좌측으로 설정
                elif arr[ci][cj+1]==1: # 우측에 길이 있으면
                    dr = 1 #방향을 우측으로 설정
            else: #좌우를 판단하는 else문
                cj += dr # 지금 이 34라인의 dr 변수에 방향이 설정이 되어있기 때문에 더 해주면 된다.
                if arr[ci][cj+dr] == 0: # 현재 설정된 방향대로 가는데 길이 막혀있으면
                    dr = 0 # 아래로 방향을 설정한다.
        if minvalue >= cnt:
            minvalue,ans = cnt,sj-1

    print(f'#{tc} {ans}')
