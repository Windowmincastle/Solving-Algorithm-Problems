'''
러시아 국기 같은 깃발
SWEA 4613
'''
#import sys
#sys.stdin =open("input.txt","r")

T = int(input())
for tc in range(1,T+1):
    # 내가 작성한 코드
    # N,M = map(int,input().split())
    # arr = [input() for _ in range(N)]
    # cnt = 0
    # #흰색체크
    # for i in arr[0]:
    #     if i != "W":
    #         cnt +=1
    # #파란색 체크
    # for i in arr[1]:
    #     if i != "B":
    #         cnt +=1
    #
    # #빨간색 체크
    # for i in range(2,N):
    #     for j in range(M):
    #         if arr[i][j] != "R":
    #             cnt +=1

    #문어박사 코드
    N,M = map(int,input().split())
    arr = [input() for _ in range(N)]

    mx= 0
    for i in range(N-2):
        for j in range(i+1,N-1):

            cnt = 0

            for s in range(i+1):
                cnt += arr[s].count('W')
            for s in range(i + 1, j+1):
                cnt += arr[s].count('B')
            for s in range(j+1,N):
                cnt += arr[s].count('R')
            mx = max(mx,cnt)
    ans = (N*M) - mx
    
    print(f'#{tc} {ans}')
