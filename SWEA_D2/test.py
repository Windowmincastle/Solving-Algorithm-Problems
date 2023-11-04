import sys
sys.stdin =open("input.txt","r")

def solve():
    # 가로 체크
    for lst in arr:
        if len(set(lst)) != N:
            return 0 # 실패
    #전치 행렬
    arr_t = list(map(list,zip(*arr)))

    # 세로 체크
    for lst in arr_t:
        if len(set(lst)) != N:
            return 0

    # 3x3 퍼즐 체크
    for i in range(0,9,3): # 0~9까지 3씩 증가하면서 i값 0,3,6
        for j in range(0,9,3): # 0~9까지 증가하면서 j값 0,3,6
            lst = arr[i][j:j+3] + arr[i+1][j:j+3] + arr[i+2][j:j+3]
            # arr[0][0~3] 값 + arr[1][0~3] 값 + arr[2][0~3]값 을 더해서 lst에 초기화
            if len(set(lst)) != N:
                return 0
    return 1

T=int(input())

for tc in range(1,T+1):
    N=9 # N을 9로 고정
    arr = [list(map(int,input().split())) for _ in range (N)] # 9x9 퍼즐 받기, 가로 체크
    ans = solve()

    print(f"#{tc} {ans}")