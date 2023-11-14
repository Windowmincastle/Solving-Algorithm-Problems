'''
swea d2 1859

'''
import sys
sys.stdin = open('input.txt','r')

T = int(input()) # 전체 TC 갯수
for tc in range(1,T+1): # TC마다

    n = int(input()) #배열의 길이 (안쓰임)
    result = 0 #출력할 정답
    data = list(map(int, input().split())) #배열 입력 받기
    maxprice = 0 #현재 판매가격(최댓값)

    for i in data[::-1]: # 배열 거꾸로 순회
        if i >= maxprice: #현재 값이 최댓값보다 크거나 같다면
            maxprice = i #최댓값 업데이트
        else:
            result += maxprice - i #아니라면 정답값에 가격차이를 더한다. (현재 값에 구매해서 최댓값에 판다)
    print(f"#{tc} {result}") #출력 양식에 맞춰서 출력
    # 제발 테스트 케이스 앞에 # 붙이는거 좀 까먹지 말자 조심하자