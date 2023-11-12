'''
11월 12일 2번째 풀이
소 수 개 념
종료 조건 설정
디 버 깅 잘 하 자
'''
import sys
sys.stdin=open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    a=b=c=d=e= 0
    N = int(input())

    while N != 1: #조건 설정 조심
        if N % 2 == 0 :
            a += 1
            N = N / 2
        elif N % 3 == 0:
            b += 1
            N = N / 3
        elif N % 5 == 0:
            c += 1
            N = N / 5
        elif N % 7 == 0:
            d += 1
            N = N / 7
        elif N % 11 == 0:
            e += 1
            N = N / 11

    print(f'#{tc} {a} {b} {c} {d} {e}')