'''
오랜만에 재귀로 풀라니까 종료 조건 설정이 기억이 안남;;
근데 핵심 방법은 알고있어서 그냥 답 보고 넘어감
다음에 다시 풀어보기 - 현재 11월 10일

'''
import sys
sys.stdin=open('input.txt','r')

def recursive(N,M):

    if M == 0 :
        return 1 # 종료 조건
    else:
        return N * recursive(N,M-1)

T = 10
for tc in range(1,T+1):
    _ = input()
    N,M = map(int,input().split())
    ans = recursive(N,M)

    print(f'#{tc} {ans}')

