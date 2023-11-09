'''
파리퇴치 문제
참고 링크
https://hei-jayden.tistory.com/268

2번째 풀이 기록 - 11월 10일 금요일

'''
import sys
sys.stdin=open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]  # 이차원 리스트
    lst = []

    for i in range(0, N - M + 1):
        for j in range(0, N - M + 1):
            tmp = 0
            for k in range(M): # N x N 배열에서 M x M 만큼 완전탐색을 하려면 4중 포문을 사용해보자.
                for l in range(M):
                    tmp += arr[i + k][j + l]
                    lst.append(tmp)

    print(f'#{tc} {max(lst)}')
