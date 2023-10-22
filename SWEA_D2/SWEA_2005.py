'''
문제 링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1
'''
T = int(input())
for tc in range(1, T + 1) :

    n = int(input())
    data = [[0] * n for _ in range(n)]

    for i in range(n) :
        data[i][0] = 1 # n=5라면?
        #[0][0],[1][0],[2][0],[3][0],[4][0],[5][0] 즉 왼쪽의 모든 값을 1로 초기화한거

    for i in range(1, n) :
        for j in range(1, n) : #2번째 행 부터 연산
            data[i][j] = data[i-1][j-1] + data[i-1][j] #
            # 2차원 리스트의 왼쪽 대각선 위 data[i-1][j-1] , 위 data[i-1][j]의 합으로 [i][j] 갱신

    print(f"#{tc}") # testcase 번호 출력 # 붙여서 출력하는거 주의하자

    for i in range(n) :
        for j in range(n) :
            if data[i][j] != 0 : #리스트의 요소를 0이 아닐시에만 하나 씩 이중 반복문으로 출력한다.
                print(f"{data[i][j]}", end=' ')
        print()#한행 작업 끝나면 줄 바꿈