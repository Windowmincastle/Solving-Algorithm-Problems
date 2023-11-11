'''
SWEA D2 1976 시각 덧셈
문제링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PttaaAZIDFAUq&categoryId=AV5PttaaAZIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2
문제 풀이 소요시간 - 15분

생각보다 쉽게 풀림.
'''
import sys
sys.stdin = open("input.txt", "r")
T = int(input())
for tc in range(1,T+1):

    hour1,min1,hour2,min2 = list(map(int,input().split()))
    ans_hour=0
    ans_min=0

    if (hour1+hour2) > 12:
        ans_hour = (hour1+hour2) % 12
    else:
        ans_hour = hour1+hour2

    if (min1+min2) > 59 :
        ans_min = (min1+min2) % 60
        ans_hour += 1
    else:
        ans_min = min1+min2

    print(f"#{tc} {ans_hour} {ans_min}")
