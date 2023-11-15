'''
swea d3 6485 삼성시의 버스 노선
'''
import sys
sys.stdin = open('input.txt','r')

T = int(input())
for tc in range(1, T + 1):

    n = int(input())

    cnt = [0] * 5001 # 5000개 버스 정류장
    for _ in range(n):
        s,e = map(int,input().split())
        for i in range(s,e+1): # start부터 end까지
            cnt[i] += 1 #리스트에 노선 수 를 표시

    P = int(input())
    ans = [] # counting sort 처럼
    for _ in range(P):
        t = int(input())
        ans.append(cnt[t]) #cnt배열의 t자리의 값을 sol 리스트에 append

    print(f"#{tc}", *ans)