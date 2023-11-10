'''
1979. 어디에 단어가 들어갈 수 있을까
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PuPq6AaQDFAUq&categoryId=AV5PuPq6AaQDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

이 문제 혼자 못 풀엇음. 참고 링크
https://unie2.tistory.com/1001

느낀점
일단 시발 문제 접근 방법부터 틀렷다.
나는 모든 x,y요소에 접근해서 k의 길이만큼 체크하고 그 뒤가 막혔거나 좌표의 밖이면
cnt를 +1하려고 했는데 사람들은 이렇게 풀지 않았다.
또 문제를 잘못 이해했다. 그림을 봤을 때 가로 세로 이렇게 화살표가 있으면
당연히 가로로도 체크하고 세로로도 체크할 수 있다는 생각을 해야하는데 왜
단편적으로 가로만 생각할 수 잇다고 생각한건지 바본가..?;;

그래도 참고 코드를 보고나니 막 생각하지 못 할 방법은 아닌 것 같다.
꼭 다시 한번 풀어보길바람
"미래의 다시 풀어보는 김민성에게 힌트 "
흰색 = 빈곳 = 1 , 검은색 = 막힌곳 = 0
k의 수가 주어지는데 x,y 요소에 다 접근해서 k의 수를 세다가
다음 x,y를 체크하는데 그곳이 0이거나 , 좌표의 끝이면
cnt와 k를 체크해보면 되지않겟니?
'''
'''
11월 10일 3번째 풀이 했는데 정답에 거의 근접했으나 틀렸다. 다시 풀어보기 노션에 정리했음.
'''
import sys
sys.stdin = open("input.txt", "r")
# 하 진짜 바보 바보 핵 바보 아주 사소한 실수로 헤매네 ;;
# 전역변수 지역변수 변수 이름 항상 조심해라
# 로직에 문제가 없는 것 같다면 항상 변수 명을 정확히 넣엇는지 ? 변수명이 겹치는건 없는지 체크해봐라
# 만약 시험 중 이라면? 이딴거 생각할 틈이 없을 것 이니 아예 코드를 싹 다 지우고 처음부터 작성해봐라
T = int(input())
for tc in range(1,10+1):

    n,k= map(int,input().split()) # n,k 입력
    arr = [list(map(int, input().split()))+[0] for _ in range(n)]+[[0]*(n+1)] # 퍼즐 입력받을때 0으로 패딩해서 받기
    arr_t = list(map(list, zip(*arr))) # 퍼즐을 전치 행렬로 만들기
    ans = 0

    # 가로 체크
    for x in range (n+1):
        cnt = 0
        for y in range(n+1):
            if arr[x][y] == 1 :
                cnt += 1
            else: # 0인 경우
                if cnt == k:
                    ans += 1
                cnt = 0  # 여기서 cnt를 다시 0으로 만드는 조건을 까먹으면 안된다.

    #세로 체크 (전치행렬)
    for x in range(n+1): #
        cnt = 0
        for y in range(n+1):
            if arr_t[x][y] == 1: # i j k l 넣는거 조심하자 항상 변수 이름도 조심하고
                cnt += 1
            else:
                if cnt == k:
                    ans += 1
                cnt = 0  # 여기서 cnt를 다시 0으로 만드는 조건을 까먹으면 안된다.

    print(f"#{tc} {ans}")