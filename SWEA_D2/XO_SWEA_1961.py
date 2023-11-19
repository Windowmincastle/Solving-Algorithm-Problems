'''
SWEA D2 1961 숫자 배열 회전
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1

푸는데 1시간 30분 정도 걸린 것 같다
물론 이것 저것 연습하면서 푼다고 좀 오래 걸리기도 했지만
혼자 아이디어를 떠올려서 풀어낸 것에 만족한다.

이런 문제 유형이 나오면 전치행렬을 뒤집는 방식을 활용하면 좋을 것 같다
그리고 A4 용지를 한장 크게 N x N으로 숫자를 채우고 90도로 돌려보는 방식을
직접 눈 앞에서 해보니까 이해하는데 됐따

11월 12일 일요일 필기
이 방법으로 말고 다른 방법으로 풀려고 했으나 실패했다. 노션에 best case 코드를 정리했으니 참고바람.
'''
import sys
sys.stdin=open('input.txt','r')

def rotate(arr):
    arr_r = [[0]*N for _ in range(N)] #반환 배열 생성
                # [1,2,3] 인 상황이면
                # [4,5,6]
                # [7,8,9]
    for i in range(N):          # N = 3
        for j in range(N): # N=2-1-j , j= 0~2 , 3-1-0, 3-1-1, 3-1-2, = [2][0],[1][0],[0][0] 변화
            arr_r[i][j] = arr[N-1-j][i]
    return arr_r

T = int(input())
for tc in range(1,T+1):

    N = int(input())
    arr = [list(map(int,input().split())) for _ in range(N)]

    arr1 = rotate(arr) # 원본을 90도
    arr2 = rotate(arr1) # 90도를 90도 = 180도
    arr3 = rotate(arr2) # 180도를 90도 = 270도

    print(f'#{tc}')
    for a,b,c in zip(arr1,arr2,arr3): #zip으로 arr1,2,3 묶어서 a,b,c,에 한 행씩 받기
        print(f'{"".join(map(str,a))} {"".join(map(str,b))} {"".join(map(str,c))}')
        #map으로 str로 변환해서 join함수 사용해서 빈 문자열과 결합