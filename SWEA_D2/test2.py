import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1,T+1):

    N,K= map(int,input().split()) # n,k 입력
    #arr = [list(map(int, input().split()))+[0] for _ in range(n)]+[[0]*(n+1)] # 퍼즐 입력받을때 0으로 패딩해서 받기
    arr = [list(map(int, input().split())) + [0] for _ in range(N)] + [[0]*(N+1)] # 가로 세로에 패딩을 주는 방법
    arr_t = list(map(list,zip(*arr))) # 퍼즐을 전치 행렬로 만들기

    ans = 0

    #가로
    for lst in arr:
        cnt = 0
        for j in range(len(lst)):
            if lst[j]:
                cnt += 1
            else:
                if cnt == K :
                    ans += 1
                cnt = 0
    #세로
    for lst1 in arr_t:
        cnt = 0
        for l in range(len(lst1)):
            if lst1[l]:
                cnt += 1
            else:
                if cnt == K :
                    ans += 1
                cnt = 0

    print(f"#{tc} {ans}")