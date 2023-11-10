'''
SWEA D2 1986 지그재그 숫자
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PxmBqAe8DFAUq&categoryId=AV5PxmBqAe8DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1

'''
import sys
sys.stdin = open('input.txt','r')

T=int(input())

for tc in range(1,T+1):

    N = int(input())
    ans = 0

    for i in range(1,N+1):

        if i % 2 == 0 :
            ans -= i
        else:
            ans += i

    print(f'#{tc} {ans}')