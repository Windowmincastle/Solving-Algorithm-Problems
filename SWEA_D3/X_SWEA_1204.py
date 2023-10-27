import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1,T+1):

    tcn = int(input()) # 안 쓰임
    score = list(map(int,input().split()))
    ans = 0
    lst = [0] * 101

    #계수정렬을 통한 각 점수의 빈도를 센다.
    for i in range(1000):
        lst[score[i]] += 1

    cnt = max(lst) # lst 리스트에서 가장 큰 value를 저장

    #print(f"{lst.index(cnt)} 찍어보기")

    for i in range(101): #i가 0~100 범위
        if lst[i] == cnt: # lst[0~100] 범위 중 value가 cnt와 같은 값을 만나면

            ans = i # 현재 i의 값 을 ans에 저장 즉 lst[i]가 lst[lst.index(cnt)] value는 같지만 index는 높다

    print(f"#{tc} {ans}")

