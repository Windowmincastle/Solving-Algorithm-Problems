'''
SWEA D3 1860 진기의 최고급 붕어빵
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LsaaqDzYDFAXc

틀렷음 다시 풀어보기 아래는 10월 29일에 틀린 코드
'''
import sys
sys.stdin = open("input.txt","r")

T = int(input())

for tc in range(1,T+1):

    N,M,K = list(map(int,input().split()))
    ctr = list(map(int,input().split()))

    ctr_time = min(ctr)
    print(f"가장 빨리 오는 손님 시간 {min(ctr)}, 제조 시간 {M}")

    ctr_cnt = len(ctr)
    print(f"손님 숫자 {ctr_cnt} , 붕어빵 개수 {K}")
    ans =""
    if M <= ctr_time and ctr_cnt <= K:
        ans = "Possible"
    else:
        ans = "Impossible"

    print(f"#{tc} {ans}")
