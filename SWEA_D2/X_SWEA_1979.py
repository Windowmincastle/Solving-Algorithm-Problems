'''
1979. 어디에 단어가 들어갈 수 있을까
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PuPq6AaQDFAUq&categoryId=AV5PuPq6AaQDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

이 문제 혼자 못 풀엇음. 참고 링크
https://unie2.tistory.com/1001

느낀점
일단 시발 문제 접근 방법부터 틀렷다.
나는 모든 x,y요소에 접근해서 k의 길이만큼 체크하고 그 뒤가 막혔거나 좌표의 밖이면
cnt를 +1하려고 했는데 사람들은 이렇게 풀지 않았다.
또 문제를 잘못 이해했다. 그림을 봤을 때 가로 세로 이렇게 화살표가 있으면
당연히 가로로도 체크하고 세로로도 체크할 수 있다는 생각을 해야하는데 왜
단편적으로 가로만 생각할 수 잇다고 생각한건지 바본가..?;;

그래도 참고 코드를 보고나니 막 생각하지 못 할 방법은 아닌 것 같다.
꼭 다시 한번 풀어보길바람
"미래의 다시 풀어보는 김민성에게 힌트 "
흰색 = 빈곳 = 1 , 검은색 = 막힌곳 = 0
k의 수가 주어지는데 x,y 요소에 다 접근해서 k의 수를 세다가
다음 x,y를 체크하는데 그곳이 0이거나 , 좌표의 끝이면
cnt와 k를 체크해보면 되지않겟니?
'''

# #------------내가 푼 틀린 코드 -----
# T = int(input())
#
# for tc in range(1,T+1):
#
#     n,k = map(int,input().split())
#     data = [list(map(int, input().split())) for _ in range(n)]
#     # print(data)
#
#     cnt = 0
#     sum = 0
#     for i in range(n):
#         for j in range(n-k):
#             for l in range(k):
#                 sum += data[i][j+l]
#                 if data[i][k+1] != 0:
#                     cnt += 1
#
#     print(f"#{tc} {cnt}")

t = int(input())

for tc in range(1, t + 1):
    n, k = map(int, input().split())
    data = [list(map(int, input().split())) for _ in range(n)]

    result = 0
    # 가로 확인
    for i in range(n):
        cnt = 0
        for j in range(n):
            if data[i][j] == 1:
                cnt += 1
            if data[i][j] == 0 or j == n - 1:
                if cnt == k:
                    result += 1
                if data[i][j] == 0:
                    cnt = 0

    # 세로 확인
    for i in range(n):
        cnt = 0
        for j in range(n):
            if data[j][i] == 1:
                cnt += 1
            if data[j][i] == 0 or j == n - 1:
                if cnt == k:
                    result += 1
                if data[j][i] == 0:
                    cnt = 0

    print('#%d %d' % (tc, result))