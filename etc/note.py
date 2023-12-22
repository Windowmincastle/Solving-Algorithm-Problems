'''
로봇 청소기
'''
# 방향 정의 : 북 동 남 서
di = [-1,0,1,0]
dj = [0,1,0,-1]
def cleaning(ci,cj,dr):

    cnt = 0 # 청소한 공간의 수
    # 끝나면 탈출하기 때문에 무한루프로
    while 1: #청소기가 더 이상 움직이지 못 할때 종료
        # <1> 현재 위치 청소
        arr[ci][cj] = 2 # 청소하고 2로 변경
        cnt += 1 # 청소 횟수 증가

        # <2> 왼쪽 방향으로 순서대로 탐색해서 미청소 영역이 있으면 이동/방향 회전
        flag = 1 # 탈출 플래그
        while flag == 1: # 플래그가 1인 경우 계속 진행
            # 왼쪽부터 네방향 미청소 영역을 탐색. 음수를 방지하기위해 보수 계산으로 방향 설정
            for next in ((dr+3)%4, (dr+2)%4,(dr+1)%4,dr):
                ni,nj = ci+di[next], cj+dj[next]
                # 청소가 안된 영역이라면 진입.
                if arr[ni][nj] == 0:
                    ci,cj,dr = ni,nj,next
                    # 1번 단계로 가기 위한 탈출 플래그
                    flag = 0 # while문 탈출
                    break # for문 탈출
            else: # 4방향 모두 미청소 영역이 없다면 ? ==> 후진
                # <1> 후진할 영역이 벽이냐?
                back_i,back_j = ci-di[dr], cj-dj[dr] #후진 위치 계산
                if arr[back_i][back_j] == 1: # 벽이라면 진입
                    return cnt # 종료
                # <2> 벽이 아니면 후진
                else:
                    ci,cj = back_i,back_j
                    #여기 진입한다면 다시 <2> 단계while문에서 4방향 탐색
    return -1

N,M = map(int,input().split())
si,sj,dr = map(int,input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

ans = cleaning(si,sj,dr) # 시작좌표와 방향을 넘겨준다.
print(ans)