'''
파이썬 제출없음 주의
1285 아름이의 돌 던지기
문제링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18-stqI8oCFAZN
'''
import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1,T+1):

    N = int(input()) #돌 던지는 사람 수
    lst = list(map(int,input().split())) # 위치 정보
    min_value = 0
    cnt = 0

    for i in range(len(lst)): # 절대값으로 lst의 값을 바꾼다.
       lst[i] = abs(lst[i])

    min_value = min(lst) # 가장 작은 수를 구해서 min_value에 저장한다. 가장 작은 수가 0과 젤 가까운 수 니까
    cnt = lst.count(min_value) # cnt에 가장 가까운 수에 돌을 던진 사람의 수를 저장한다.

    print(f"#{tc} {min_value} {cnt}")
