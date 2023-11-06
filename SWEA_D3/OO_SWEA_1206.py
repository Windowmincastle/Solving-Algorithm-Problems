'''
D3 1206 - View
문제 링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=S%2FW&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=30&pageIndex=1
'''

'''
2번째 풀었는데 생각보다 깔끔하게 잘 풀엇다. 옛날 코드보다 나은듯
T = 10
for tc in range(1,T+1):

    N = int(input())
    h = list(map(int,input().split())) # 건물 높이 리스트

    ans = 0
    for i in range(2,N-1): # 좌우측 2칸은 항상 건물의 높이가 0 이다.
        tmp = 0
        # 건물 i의 좌우측 2칸의 건물 높이가 i 건물의 높이보다 낮은지 체크
        if h[i] > h[i-1] and h[i] > h[i-2] and h[i] > h[i+1] and h[i] > h[i+2]:
            tmp = max(h[i-1],h[i-2],h[i+1],h[i+2]) # 조건에 만족하면 좌우측 4개의 건물 중 가장 높은 건물을 tmp에 저장
            ans += h[i] - tmp # 현재 건물 i의 높이와 tmp를 뺀다.

    print(f"#{tc} {ans}")
'''
for tc in range(1,10+1):
    #맨 처음에는 건물의 개수와 높이를 이차원 리스트로 시각적으로 표현해서 각 좌표에 모두 접근해서 -1 , -2 , +1 , +2를 하려고 했는데
    #잘못된 접근이였다. 문제 이해를 잘못했다. count에 건물이 100개인지 10개인지 50개인지 입력받는 것 이다.
    #height는 각 건물의 높이다
    count = int(input()) # 건물의 개수를 입력받는다.
    height = list(map(int,input().split())) # 리스트로 높이를 입력받는다.
    answer = 0 #정답을 저장할 answer 변수
    for i in range(2,count-1): # 2,count-1까지 range 범위를 정하는 이유는 좌측과 우측의 2칸은 건물이 없기 때문이다.

        temp = list() # 빈 temp 리스트를 만들고
        if height[i] > height[i-1] and height[i] > height[i-2] and height[i] > height[i+1] and height[i] > height[i+2]:
            #if문에서 i-1 , i-2 , i+1 , i+2 즉 건물의 좌측 우측 2칸씩 체크해서 진입한다.
           temp.append(height[i-1]) #진입 했다면 if문이 true니까 각 건물의 좌우측을 temp 리스트에 append로 추가한다.
           temp.append(height[i-2])
           temp.append(height[i+1])
           temp.append(height[i+2])

           maxvalue = max(temp) # 4개의 건물 중 가장 큰 건물의 값을 maxvalue에 넣는다
           count += height[i] - maxvalue # 좌우측의 조망이 확보되어야하기 때문에 4개의 건물 중 가장 큰 건물의 높이 - i 건물을 하면 조망권 확보 세대 수 이다.
    print(f"#{tc} {answer}") # 출력

'''
코드가 좀 구린거 같아서 GPT한테 코드를 간결하게 해달라 했는데 이렇게 해줌 괜찮은듯
for tc in range(1, 11):
    count = int(input())  # 건물 수 입력
    height = list(map(int, input().split()))  # 건물 높이를 리스트로 입력받음

    answer = 0
    for i in range(2, count - 1):
        if height[i] > height[i-1] and height[i] > height[i-2] and height[i] > height[i+1] and height[i] > height[i+2]:
            max_height = max(height[i-2], height[i-1], height[i+1], height[i+2]) 이 부분이 이렇게 했으면 더 깔끔하긴 하네
            answer += height[i] - max_height

    print(f"#{tc} {answer}")
'''