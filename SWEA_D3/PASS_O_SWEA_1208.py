'''
문제 링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=S%2FW&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=30&pageIndex=1

'''



for tc in range(1,11):

    dump = int(input()) # 덤프 횟수가 주어진다.
    h = list(map(int,input().split())) # 각 상자의 높이를 리스트로 받는다.
    result = 0

    for _ in range(dump+1):
        maxdot = max(h) # 리스트 최고점
        mindot = min(h) # 리스트 최저점

        h[h.index(maxdot)] = h[h.index(maxdot)] - 1
        h[h.index(mindot)] = h[h.index(mindot)] + 1

        result = maxdot - mindot
        temp = maxdot - mindot

    if max(h) - min(h) <= 1: 
        result = max(h) - min(h)

    print(f"#{tc} {result}")