import sys
sys.stdin = open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    N = int(input())
    arr = [[0]*N for _ in range(N)]
    # 동 남 서 북
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]

    i , j , dr , cnt = 0 , 0 , 0 , 1
    arr[i][j] = cnt
    cnt += 1

    while cnt <= N*N:
        ni = i+dx[dr]
        nj = j+dy[dr]

        # 이동하는 경우인거
        if 0 <= ni < N and 0 <= nj < N and arr[ni][nj] == 0:
            #이동가능하다면?
            i,j = ni,nj #i랑 j에 동쪽으로 이동하는 좌표를 초기화
            arr[i][j] = cnt # 이동한 좌표에 cnt 값 초기화
            cnt +=1
        else:
            dr = (dr+1) % 4

    print(f"{tc}")
    for lst in arr:
        print(*lst)