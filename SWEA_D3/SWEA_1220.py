import sys
sys.stdin=open('input.txt','r')
'''
SWEA D3 Magnetic
11월 11일 마그네틱 풀이 도전
'''




T=10
for tc in range(1,T+1):

    N = int(input())
    arr = [ list(map(int,input().split())) for _ in range(N)]
    ans = 0

    print(f'#{tc} {ans}')