'''
백준 2630 색종이 만들기

하얀색 칸은 0
파란색 칸은 1
하얀색 , 파란색 색종이의 개수를 차례대로 출력한다.
'''
N = int(input())  # 전체 종이의 한 변의 길이 N을 입력받음
lst = [list(map(int, input().split())) for _ in range(N)]  # 각 정사각형의 색을 나타내는 2차원 리스트를 입력받음
ans = []  # 결과를 저장할 리스트

def sol(x, y, size):

    color = lst[x][y]  # 현재 부분의 색을 저장
    # 현재 부분을 모두 확인하며 색이 모두 같은지 검사
    for i in range(x, x + size):
        for j in range(y, y + size):

            if color != lst[i][j]:  # 현재 부분이 모두 같은 색이 아니라면 나누어서 다시 확인
                sol(x, y, size // 2)  # 1 구역
                sol(x, y + size // 2, size // 2)  # 2 구역
                sol(x + size // 2, y, size // 2)  # 3 구역
                sol(x + size // 2, y + size // 2, size // 2)  # 4 구역
                return

    # 현재 부분이 모두 같은 색일 경우
    if color == 0:
        ans.append(0)  # 현재 부분이 모두 하얀색이면 하얀색 색종이 개수 추가
    else:
        ans.append(1)  # 현재 부분이 모두 파란색이면 파란색 색종이 개수 추가

# 주어진 규칙에 따라 종이를 자름
sol(0, 0, N)
# 결과 출력
print(ans.count(0))  # 하얀색 색종이 개수 출력
print(ans.count(1))  # 파란색 색종이 개수 출력



