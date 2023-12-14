'''
SWEA 5789 현주의 상자 바꾸기 문제

'''
# import sys
# sys.stdin=open("input.txt",'r')
#
# T = int(input())
# for tc in range(1,T+1):
#
#     # N = 5 , K = 2
#     N,Q = map(int,input().split())
#     lst = [0] * N
#
#     for i in range(1,Q+1):
#
#         L,R = map(int,input().split())
#
#         for j in range(L,R+1):
#             lst[j-1] = i
#
#     print(f'#{tc}',*lst)
#위에는 내 코드고 아래는 문어박사님 코드
import sys
sys.stdin=open("input.txt",'r')

T = int(input())
for tc in range(1,T+1):

    # N = 5 , K = 2
    N,Q = map(int,input().split())
    lst = [0] * (N+1)
    for i in range(1,Q+1):
        L,R = map(int,input().split())
        for j in range(L,R+1):
            lst[j] = i

    print(f'#{tc}',*lst[1:])
