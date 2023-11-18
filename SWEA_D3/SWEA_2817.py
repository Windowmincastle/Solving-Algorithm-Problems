'''
swea d3 2817 부분 수열의 합
'''
import sys
sys.stdin=open('input.txt','r')


'''
k 자체가 1보다 크기 때문에 하나도 선택하지 않으면 정답을 찾을 수 없다.
n = 배열의 index , 0번째 배열의 value를 덧셈에 사용 할거냐,안 할거냐
'''
def dfs(n, sm): # 백트래킹 활용
    global ans # ans 전역 선언 필요

    if K < sm: # 가지치기, 더 이상 진행할 필요가 없을 때 종료
        return # 만약 K = 3 이라면 음수가 없는 수열 에서는 k값을 넘었다면 더 진행 할 필요가 없다.

    if n == N: # 끝 까지 진행 했을때
        if sm == K: # 현재 까지의 합이 K라면
            ans += 1 # 경우의 수를 카운트
        return

    dfs(n+1, sm+lst[n]) # 호출한 함수의 데이터 lst[n]을 합 k를 만드는 경우의 수에 포함하는 재귀 호출
    dfs(n+1, sm)        # 데이터 n을 합 k를 만드는 경우의 수에 포함 하지 않는 재귀 호출

T = int(input())
for tc in range(1, T + 1):
    N, K = map(int, input().split()) # N개 자연수, 합 K
    lst = list(map(int, input().split())) # 수열 lst , 길이 = N
    ans = 0
    dfs(0, 0)
    print(f'#{tc} {ans}')