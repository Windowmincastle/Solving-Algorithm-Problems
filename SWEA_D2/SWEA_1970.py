'''
SWEA D2 1970 쉬운 거스름돈 문제
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PsIl6AXIDFAUq&categoryId=AV5PsIl6AXIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1

전형적인 거스름돈 그리디 알고리즘 문제로 생각된다.
한 15분만에 푼것같다.

'''
import sys
sys.stdin = open("input.txt","r")

T = int(input())

for tc in range(1,T+1):

    N = int(input())
    ans =[]

    coins = [50000,10000,5000,1000,500,100,50,10]

    for coin in coins:
        a = N // coin
        ans.append(a)
        N -= a * coin

    print(f"#{tc}")
    print(*ans)