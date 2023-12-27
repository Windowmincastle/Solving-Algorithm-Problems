#색종이 수
N = int(input())
arr= [[0]*100 for _ in range(100)]

while N:

    si,sj=map(int,input().split())

    for i in range(si,si+10):
        for j in range(sj,sj+10):
            arr[i][j] = 1
    N -= 1

cnt = 0
for i in range(100):
    for j in range(100):
        if arr[i][j] != 0:
            cnt += 1

print(cnt)