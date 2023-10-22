T = int(input())

for tc in range(1,T+1):

    n = int(input())

    data = [ [0] * n for _ in range(n)] #이중 리스트를 만들고

    for i in range(n): #왼쪽을 다 1로 초기화하자
        data[i][0] = 1

    for i in range(1,n):
        for j in range(1,n):
            data[i][j] = data[i-1][j-1] + data[i-1][j] # 현재 위치의 왼쪽 위와 대각선 위( 리스트상 바로위)의 합을 저장

    print(f"#{tc}") #테스트 케이스 수 출력
    for i in range(1,n):
        for j in range(1,n):#리스트의 모든 요소에 접근한다.
            if data[i][j] != 0: # 현재 값이 0이 아닐때만 출력
                print(f"{data[i][j]}",end=' ')
        print() # 반복문 i,j 한행 끝나면 줄바꿈 해야함