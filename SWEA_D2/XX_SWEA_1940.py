'''
SWEA D2 1940 가랏! RC카
다시 풀어보기 현재 11월 5일 - 노션에 정리햇음
2번째 풀이 11월 15일 수요일
'''
import sys
sys.stdin = open("input.txt","r")

T=int(input())
for tc in range(1,T+1):

    N=int(input()) # N 입력

    speed = 0
    distance = 0

    for i in range(N):

        com = list(map(int,input().split())) # command를 list로 받는다
        if com[0] == 1: # list의 0번째는 항상 com 1 = 가속일시
            speed += com[1] # 주어진 속도만큼 더 한다.
        elif com[0] == 0: #내가 코드 이해 못 해서 좀 더 직관적으로 추가한 조건..,,,,..반성하자..
            speed += 0
        elif com[0] == 2: # com 2 = 감속일시
            if speed > com[1]:
                speed -= com[1]
            else:
                speed = 0

        distance += speed # 어우 빡대가리야
        # command 리스트에서 0이라는 명령이 들어오면 어떤 조건문에도 걸리지않고 현재 speed 변수의 값을 유지한채
        # 반복문 마지막에 distacne 변수에 더 하니까 당연히 거리가 추가 되겠지 그니까 0일땐 코드를 불필요하게 쓸 필요 없겟지 ㅡㅡ
        # 그러니까 0일 때는 조건을 판단할 필요가 없겟지
        # 참 답답하다..
    print(f"#{tc} {distance}") # 출력


