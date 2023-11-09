'''
문제 링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1
파스칼의 삼각형

2번쨰 풀이 기록 11월 10일 금요일

'''
import sys
sys.stdin = open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    N = int(input())
    arr = [ [0] * N for _ in range(N)]

    for i in range(N):
        arr[i][0] = 1 # 좌측을 1로 다 변경하고

    for i in range(1,N):
        for j in range(1,N):
            arr[i][j] = arr[i-1][j-1] + arr[i-1][j]

    print(f'#{tc}')
    for i in range(len(arr)):
        for j in range(len(arr)):
            if arr[i][j] != 0:
                print(arr[i][j],end=' ')
        print()