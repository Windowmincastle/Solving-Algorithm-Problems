'''
SWEA D2 1954 달팽이 숫자
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
11월 6일 2번째 풀이 정답에 근사하게 코드를 만들었으나 정답을 봣음. 다시 풀기

'''
import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1,T+1):

    N = int(input())
    arr = [[0] * N for _ in range(N)] # 리스트컴프리헨션으로 N*N 2차원 배열 0으로 초기화

    #동 남 서 북 방향 순환
    di=[0,1,0,-1]
    dj=[1,0,-1,0]

    i,j,cnt,dr = 0,0,1,0 # 초기화
    arr[i][j] = cnt # 0,0은 현재 cnt로
    cnt +=1

    while cnt <= N*N: # cnt가 4 * 4 보다 작은동안 while 반복
        ni = i+di[dr] # i 좌표 값 설정
        nj = j+dj[dr] # j 좌표 값 설정

        # ni,nj의 좌표의 값이 0보다 크거나 같고 N보다 작은 경우 and 값이 없는 경우
        if 0 <= ni < N and 0 <= nj < N and arr[ni][nj] == 0:
            i, j = ni, nj # i , j의 값에 좌표 값을 초기화하면서 이동한다.
            arr[i][j] = cnt # 이동한 좌표에 cnt의 값을 초기화
            cnt+=1 # cnt값 증가
        else: # 좌표를 벗어나거나 arr[ni][nj]의 값이 0이 아닌 경우에 else에 진입해서 동->남->서->북 으로 순환
            dr = (dr+1)%4 # 나머지 연산자로 방향 좌표 순환

    print(f"#{tc}")
    for lst in arr: # 배열의 행 순차적 출력
        print(*lst)