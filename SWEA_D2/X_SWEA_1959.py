'''
10월31일 화요일
SWEA D2 두 개의 숫자열
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PpoFaAS4DFAUq&categoryId=AV5PpoFaAS4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

이렇게 쉬운걸 못 풀면 어떡하냐........?
밤에 푸니까 뇌가 안 돌아가네 진짜 하 미치겟다~
다시 풀어봐라
힌트 = 반복문 인덱스 범위 설정이 중요하다

참고 풀이
https://velog.io/@tyjk8997/SWEA-%EB%91%90-%EA%B0%9C%EC%9D%98-%EC%88%AB%EC%9E%90%EC%97%B4python
https://unie2.tistory.com/989
abc
'''
#
import sys
sys.stdin = open("input.txt","r")
T = int(input())
for tc in range(1,T+1):

    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    if len(A) < len(B): # 길이가 작은 리스트와 큰 리스트를 구별
        min_lst = A
        max_lst = B
    else:
        min_lst = B
        max_lst = A

    repeat = len(max_lst) - len(min_lst) # 반복 횟수 예시 ) 5 - 3 = 2 인덱스를 2번만 옮겨가면서 비교하면 된다.
    ans = 0
    for i in range(repeat+1): # range에 넣어서 쓸꺼니까 +1
        tmp = 0
        for j in range(len(min_lst)):
            tmp += (min_lst[j] * max_lst[j + i])
        ans = max(ans, tmp)

    print(f"#{tc} {ans}")