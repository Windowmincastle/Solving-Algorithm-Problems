'''
SWEA D2 1954 달팽이 숫자
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1

'''
def myf(arr):  # 전치행렬 수행 메서드
    arr_t = list(map(list, zip(*arr)))
    return arr_t
def myf2(arr):  # 전치행렬 완료 된 이차원 배열을 메서드 호출 시 인자로
    ans = []
    for i in range(0, 3):
        ans.append([])
        for j in range(2, -1, -1):
            ans[i].append(arr[i][j])
    return ans

arr = [list(map(int, input().split())) for _ in range(3)]

t = myf(arr)  # 전치행렬 만들기
r = myf2(t)  # 90도
t2 = myf(r)  # 90도의 전치행렬
r2 = myf2(t2)  # 180도
t3 = myf(r2)  # 180도의 전치행렬
r3 = myf2(t3)  # 270도
t = 1
print(f"#{t}")
for i in range(3):
    total = str(r[i])+" "+str(r2[i])+" "+str(r3[i])
    t += 1
    print(total)

    # for lst in t:
    #     print(lst)
    #
    # print('90도 테스트')
    #
    # for lst2 in r:
    #     print(lst2)
    #
    # print("180도 테스트")
    #
    # for lst3 in r2:
    #     print(lst3)
    #
    # print("270도 테스트")
    # for lst4 in r3:
    #     print(lst4)
    #
    #
