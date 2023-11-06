'''
view 연습
'''
import sys
sys.stdin = open('input.txt','r')

T = 10
for tc in range(1,T+1):

    N = int(input())
    h = list(map(int,input().split())) # 건물 높이 리스트

    ans = 0
    for i in range(2,N-1): # 좌우측 2칸은 항상 건물의 높이가 0 이다.
        tmp = 0
        # 건물 i의 좌우측 2칸의 건물 높이가 i 건물의 높이보다 낮은지 체크
        if h[i] > h[i-1] and h[i] > h[i-2] and h[i] > h[i+1] and h[i] > h[i+2]:
            tmp = max(h[i-1],h[i-2],h[i+1],h[i+2]) # 조건에 만족하면 좌우측 4개의 건물 중 가장 높은 건물을 tmp에 저장
            ans += h[i] - tmp # 현재 건물 i의 높이와 tmp를 뺀다.

    print(f"#{tc} {ans}")