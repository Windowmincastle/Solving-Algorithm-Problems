'''
참고 링크
https://hei-jayden.tistory.com/268
'''
T = int(input())
for tc in range(1,T+1):

    # n , m 입력
    n,m = map(int,input().split())
    # n x n 배열 입력
    data = [ list(map(int,input().split())) for _ in range (n)]

    kill = [] #빈 리스트를 선언
    for i in range(n-m+1): # 파리채의 크기에따라 접근해야할 i , j 행렬의 크기가 다르기 때문에 n-m 해준다
        for j in range(n-m+1):
            fly = 0

            for k in range(m): # m x m 만큼 i와 j에 + 해서 접근해서 합을 fly에 더 해준다
                for l in range(m):
                    fly += data[i+k][j+l]
            kill.append(fly) # m x m 파리채 크기만큼 fly에 더한 값을 append로 kill 리스트에 추가

    print(f"#{tc} {max(kill)}") # kill 리스트에 max 함수 적용해서 가장 많이 죽인 값 출력
