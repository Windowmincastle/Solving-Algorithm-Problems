'''
SWEA D2 숫자를 정렬하자
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PrmyKAWEDFAUq&categoryId=AV5PrmyKAWEDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

난이도 하 3분만에 품

'''
import sys
sys.stdin = open("input.txt","r")

T = int(input())
for tc in range(1,T+1):

    N = int(input())
    lst = list(map(int,input().split()))

    ans = sorted(lst)

    print(f"#{tc}",*ans)