'''
SWEA D3 1213 - string
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV14P0c6AAUCFAYi&categoryId=AV14P0c6AAUCFAYi&categoryType=CODE&problemTitle=S%2FW&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=30&pageIndex=1

문제 풀이 소요시간 = 17분정도

'''
# 첫 번째 풀이에 이렇게 풀엇었는데
import sys
sys.stdin = open("input.txt", "r", encoding="utf-8") # 여기서 문제가 좀 잇엇는데 open이랑 encoding하는거
for _ in range(1,10+1):

    TC = int(input())
    target = input()
    lst = input()
    cnt = 0
    ans = 0

    for i in range(len(lst)):
        if lst[i:(i+len(target))] == target:
           cnt += 1

    ans = cnt

    print(f"#{TC} {ans}")
'''
2번 째 풀이
import sys
sys.stdin = open('input.txt','r')

T = 10
for tc in range(1,T+1):

    n = int(input())

    target = input()

    search = input()

    ans = search.count(target)
    print(f'#{tc} {ans}')
'''