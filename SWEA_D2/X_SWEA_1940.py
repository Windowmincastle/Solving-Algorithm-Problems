'''
SWEA D2 1940 가랏! RC카
다시 풀어보기 현재 11월 5일 - 노션에 정리햇음

'''
import  sys
sys.stdin = open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    N = int(input())

    command , speed = map(int,input().split())

    distance = 0
    if command == 1:
        distance += speed
    elif command == 0:
        distance += speed
    elif command == 2:
        if speed > distance:
            distance = 0
        else:
            distance -= speed

    ans = distance
    print(f'#{tc} {ans}')