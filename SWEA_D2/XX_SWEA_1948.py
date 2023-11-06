'''
SWEA D2 1948 날짜 계산기
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PnnU6AOsDFAUq&categoryId=AV5PnnU6AOsDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

'''
import sys

sys.stdin = open("input.txt", "r")
months = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
T = int(input())
#2번 풀이
for tc in range(1,T+1):
    m1 , d1, m2, d2 = map(int,input().split())
    ans = 0

    # 같은 달 위치할 경우
    if m1 == m2 :
        ans = d2 - d1 + 1
    else:
        # 시작하는 달
        ans = months[m1] - d1 +1
        # 중간에 있는 달
        for i in range(m1+1,m2):
            ans += months[i] # 중간달의 값을 더해준다.
        # 마지막 달
        ans += d2
    print(f'#{tc} {ans}')


# for tc in range(1,T+1):
#
#     m1,d1,m2,d2 = map(int,input().split())
#
#     all_day = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365]
#
#     ans = (d2 + all_day[m2-1]) - (d1 + all_day[m1-1])+1
#     # 현재 달의 날짜와 이전 달 까지의 누적 날짜를 더한 후 비교 날짜와 누적 날짜를
#     # 비교해서 뺀다.
#     print(f"#{tc} {ans}")