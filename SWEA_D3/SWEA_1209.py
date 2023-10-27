'''
swea d3 1209 - Sum
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV13_BWKACUCFAYh&categoryId=AV13_BWKACUCFAYh&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=6&&&&&&&&&&
50분만에 풀엇따!! 나이스
'''
import sys
sys.stdin = open("input.txt", "r")

for _ in range(1,10+1):

    n = int(input())
    arr = [ list(map(int,input().split())) for _ in range(100)] # 100 x 100 이차원 배열
    arr_t = list(map(list,zip(*arr))) #전치 행렬 변환.
    ans = 0 # 정답 저장할 변수.

    maxlst = [] # 행의 합, 열의 합, 대각선의 합 , 반대 대각선의 합을 저장할 리스트

    #행의 합
    for i in range(100):
        maxlst.append(sum(arr[i]))
    #전치행렬의 행의 합 = 열의 합
    for j in range(100):
        maxlst.append(sum(arr_t[j]))

    #zip으로 활용하기 위한 line list 생성
    line = [x for x in range(100)]
    line2 = [y for y in range(100)]

    #대각선의 합
    linesum = 0
    for k,l in zip(line,line2):
        linesum += arr[k][l]
    arr.append(linesum)

    #대각선을 역순으로 처리하기 위해 reversed
    line = list(reversed(line))
    line2 = list(reversed(line2))

    #반대 대각선의 합
    for q,r in zip(line,line2):
        linesum += arr[q][r]
    arr.append(linesum)

    ans = max(maxlst)
    print(f"#{n} {ans}")

