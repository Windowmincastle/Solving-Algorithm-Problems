'''
SWEA D3 4831 전기버스
https://swexpertacademy.com/main/learn/course/lectureProblemViewer.do

틀림 = 현재 날짜 11월 6일 월요일

힌트 - 시작 지점과 끝 지점을 변형 시키는 것, 시작 - i 정류장이 K 보다 크다면 시작점을 바꿀것

'''
import sys
sys.stdin = open('input.txt','r')

T = int(input())
for tc in range(1,T+1):
    # 최대 이동 거리, 정류장 수 , 설치된 정류장 수
    K,N,M = map(int,input().split())
    lst = [0] + list(map(int,input().split())) + [N]

    ans = start = 0

    for i in range(1,M+2):
        # 0이 되는 조건
        if lst[i] - lst[i-1] > K :
            ans = 0
            break

        if lst[i] - start > K :
            start = lst[i-1]
            ans +=1

    print(f'#{tc} {ans}')