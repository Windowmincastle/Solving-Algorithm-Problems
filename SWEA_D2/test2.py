def myf(arr):
    arr_t = list(map(list, zip(*arr)))
    return arr_t

def myf2(arr):
    ans = []
    for i in range(0, N):
        ans.append([])
        for j in range(N-1, -1, -1):
            ans[i].append(arr[i][j])
    return ans
import sys
sys.stdin = open("input.txt","r")

T=int(input())
for tc in range(1,T+1):

    N=int(input())
    arr = [ list(map(int, input().split())) for _ in range(N)]

    t = myf(arr)
    r = myf2(t) # 90도
    t2 = myf(r)
    r2 = myf2(t2) # 180도
    t3 = myf(r2)
    r3 = myf2(t3) # 270도

    print(f"#{tc}")
    for i in range(N):
        for row in r, r2, r3:
            print("".join(map(str, row[i])), end=' ')
        print()
