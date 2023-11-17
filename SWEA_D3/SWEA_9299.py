'''
SWEA D3 9299 한빈이와 Spot mart
'''
import sys
sys.stdin = open('input.txt','r')

T=int(input())
for tc in range(1,T+1):

    n , m = map(int,input().split()) # 과자 봉지의 개수, 무게 합 제한
    lst = list(map(int,input().split()))

    cart=[]
    for i in range(n):
        for j in range(n):
            if lst[i] + lst[j] <= m :
                cart.append(lst[i] + lst[j])

    if len(cart) == 0 :
        print(f'#{tc} -1')
    else:
        print(f'#{tc} {max(cart)}')
