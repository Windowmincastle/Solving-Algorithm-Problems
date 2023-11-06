'''
SWEA D3 농작물 수확하기
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
1차 풀이 : 11월 6일 월요일 8시 40분
'''

import sys
sys.stdin = open("input.txt",'r')

T=int(input())
for tc in range(1,T+1):

    N = int(input())
    arr = [ list(map(int,input().split())) for _ in range(N)] # 농장 N x N
    center = N
    tmp = N//2

    # 윗라인 0
    for i in range(0,center):
        for j in range(N//2,0,-1):
            arr[i][j-i] = 0

