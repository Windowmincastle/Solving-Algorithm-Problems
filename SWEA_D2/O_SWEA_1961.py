'''
SWEA D2 1961 숫자 배열 회전
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1

푸는데 1시간 30분 정도 걸린 것 같다
물론 이것 저것 연습하면서 푼다고 좀 오래 걸리기도 했지만
혼자 아이디어를 떠올려서 풀어낸 것에 만족한다.

이런 문제 유형이 나오면 전치행렬을 뒤집는 방식을 활용하면 좋을 것 같다
그리고 A4 용지를 한장 크게 N x N으로 숫자를 채우고 90도로 돌려보는 방식을
직접 눈 앞에서 해보니까 이해하는데 됐따

참고 링크
https://velog.io/@yb_engineer/Algorithm-SWEA-1961.%EC%88%AB%EC%9E%90%EB%B0%B0%EC%97%B4%ED%9A%8C%EC%A0%84-python

'''
import sys
sys.stdin = open("input.txt","r")
def transpose(arr):
    arr_t = list(map(list, zip(*arr)))
    return arr_t

def flip(arr):
    ans = []
    for i in range(0, N):
        ans.append([])
        for j in range(N-1, -1, -1):
            ans[i].append(arr[i][j])
    return ans

T=int(input())
for tc in range(1,T+1):

    N=int(input())
    arr = [ list(map(int, input().split())) for _ in range(N)]

    #90도
    t90 = transpose(arr)
    f90 = flip(t90)

    #180도
    t180 = transpose(f90)
    f180 = flip(t180)

    #270도
    t270 = transpose(f180)
    f270 = flip(t270)

    print(f"#{tc}")
    for i in range(N): # 이 출력 포맷 익숙치 않음. 연습하기
        for row in f90, f180, f270:
            print("".join(map(str, row[i])), end=' ')
        print()
