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

# 아래 접어놓은거 내 생각엔 best code
'''BestCode
# import sys
# sys.stdin = open("input.txt", "r")

def myf(lst, ip ):
    highidx = 0  # 가장 높은 인덱스 저장할 변수
    for idx, val in enumerate(lst):
        if val == ip:
            highidx = idx  # 더 높은 인덱스로 갱신
    return highidx

T = int(input())
for _ in range(1,T+1):

    tc = int(input()) # 테스트 케이스
    score = list(map(int,input().split())) # 학생들 점수
    lst = [0] * 101 # count sort , 점수 0~100점

    #계수정렬을 통한 각 점수의 빈도 카운트.
    for i in range(1000): # 학생 1000명 고정
        lst[score[i]] += 1
    cnt = max(lst) # lst 리스트에서 가장 큰 value를 저장

    ans = myf(lst,cnt) # 중복 체크를 위한 함수.

    print(f"#{tc} {ans}")


'''

