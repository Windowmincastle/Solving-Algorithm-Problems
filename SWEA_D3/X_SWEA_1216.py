'''
1216. [S/W 문제해결 기본] 3일차 - 회문2
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV14Rq5aABUCFAYi&categoryId=AV14Rq5aABUCFAYi&categoryType=CODE&problemTitle=S%2FW&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=20&pageIndex=1

'''
import sys
sys.stdin = open('input.txt','r')
def pal(arr,leng):
    for lst in arr:
        for i in range(N-leng+1): # 100 - 99 + 1 = 0번째 인덱스부터
            #      0:0+99    ==     0~0+99 뒤집기 최대값을 빨리 찾기 위해서 큰 길이부터 깎으면서 찾는다
            if lst[i:i+leng] == lst[i:i+leng][::-1]: # 길이가 leng인 회문을 찾는 것
                return True #참 거짓을 반환해야하는 이유는? if문에서 호출을 했기 때문
    return False # 다 돌앗는데 없으면 Fals

T = 10
for tc in range(1,T+1):
    _ = int(input())
    N = 100
    arr = [input() for _ in range(N)]
    arr2 = [''.join(x) for x in zip(*arr)] # 전치행렬 만들어서 문자열로 받는것

    for leng in range(N, 1, -1): # 100부터 -1씩 감소하면서
        if pal(arr,leng) or pal(arr2,leng): # 반복문안의 if문 조건에 함수 2개를 호출
            break # 100부터 감소시키면서 회문을 찾기 때문에 회문을 찾앗을 때 보다 큰 회문 결과는 있을 수 없다

    print(f'#{tc} {leng}')