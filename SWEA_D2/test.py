import sys
sys.stdin = open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    N , M = map(int,input().split())
    arr = [ list(map(int,input().split())) for _ in range(N)] # 이차원 리스트
    ans = 0
    lst = []

    for i in range(0,N-M+1):
        for j in range(0,N-M+1):
            tmp = 0
            for k in range(M):
                for l in range(M):
                    tmp += arr[i+k][j+l]
                    lst.append(tmp)
    ans = max(lst)
    print(f'#{tc} {ans}')