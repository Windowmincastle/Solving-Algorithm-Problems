'''
10월31일 화요일
SWEA D2 두 개의 숫자열
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PpoFaAS4DFAUq&categoryId=AV5PpoFaAS4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

이걸 또 틀리네 시발...11월 6일
힌트 = range 범위 설정이 중요하다

참고 풀이
https://velog.io/@tyjk8997/SWEA-%EB%91%90-%EA%B0%9C%EC%9D%98-%EC%88%AB%EC%9E%90%EC%97%B4python
https://unie2.tistory.com/989
abc
'''
import sys
sys.stdin = open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    N,M = map(int,input().split())
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))

    maxlst = []
    minlst = []
    if len(A) > len(B):
        maxlst = A
        minlst = B
    else:
        maxlst = B
        minlst = A

    repeat = len(maxlst) - len(minlst) # 왜 +1을 해야하지?
    ans = 0
    print(repeat)
    for i in range(repeat+1): # 반복문 범위가 틀렷엇나보다...시발
        tmp = 0
        for j in range(len(minlst)):
            tmp += minlst[j] * maxlst[j+i]
        ans = max(ans,tmp)

    print(f'#{tc} {ans}')