import sys
sys.stdin = open("input.txt", "r")
def count(arr):
    ret = 0
    for lst in arr:
        cnt = 0
        for j in range(len(lst)):
            if lst[j]:  # 값이 0이 아닌경우
                cnt+=1
            else:
                if cnt == K:
                    ret += 1
                cnt = 0 # 어쨋든 0을 만나면 cnt를 초기화 해야하기 때문에 else와 관계없이 0으로 초기화 해야한다.
    return ret

T = int(input())

for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    arr = [list(map(int, input().split())) + [0] for _ in range(N)] + [[0]*(N+1)] # 가로 세로에 패딩을 주는 방법
    arr_t = list(map(list,zip(*arr))) # 전치 행렬을 만드는 방법

    ans = count(arr) + count(arr_t)
    print(f'#{test_case} {ans}')