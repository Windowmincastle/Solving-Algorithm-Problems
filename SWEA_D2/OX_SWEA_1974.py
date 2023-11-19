'''
SWEA_1974 스도쿠 검증
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Psz16AYEDFAUq&categoryId=AV5Psz16AYEDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1

'''

'''
아이디어는 나랑 사람들이랑 거의 다 비슷하다 잘 접근해보길 바람
문법을 잘 활용하지 못 해서 구현할 접근을 하지 못 한 거 같다.
힌트 : 리스트 슬라이싱을 잘 써야한다.

11월3일 오전 1:03분 다시 풀어봤음.
'''
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
            lst = arr[i][j:j+3] + arr[i+1][j:j+3] + arr[i+2][j:j+3]# 3x3 사이즈
            # arr[0][0~3] 값 + arr[1][0~3] 값 + arr[2][0~3]값 을 더해서 lst에 초기화
            if len(set(lst)) != N: # set에 넣어서 판단
                return 0
    return 1

T=int(input())

for tc in range(1,T+1):
    N=9 # N을 9로 고정
    arr = [list(map(int,input().split())) for _ in range (N)] # 9x9 퍼즐 받기, 가로 체크
    ans = solve()

    print(f"#{tc} {ans}")