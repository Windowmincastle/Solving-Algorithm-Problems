'''
swea d2 1284 수도 요금 경쟁
'''
import sys
sys.stdin=open('input.txt','r')

T =int(input())
for tc in range(1,T+1):
    #
    # 9 100 20 3 10리터
    p,q,r,s,w = map(int,input().split())

    a = p * w
    b = 0
    # 사용량이 b사의 기준보다 낮은 경우
    if w <= r:
        b = q
    elif w >= r: # 사용량이 b사 기준보다 높은 경우
        b = q + ( (w-r) * s)

    ans = min(a,b)

    print(f'#{tc} {ans}')