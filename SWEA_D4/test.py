import sys
sys.stdin =open("input.txt","r")

T=int(input())

for tc in range(1,T+1):

    arr = [list(map(int,input().split())) for _ in range (9)]

    for lst in arr:
        print(lst)