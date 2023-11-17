import sys
sys.stdin=open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    n = int(input())
    arr=[[0] * n for _ in range(n)]

    di=[0,1,0,-1]
    dj=[1,0,-1,0]

    i,j,dr,cnt = 0,0,0,1

    arr[i][j] = cnt

    while cnt < n*n:

        ni,nj = i+di[dr],j+dj[dr]

        if 0<= ni < n and 0<= nj < n and arr[ni][nj] == 0:
            i,j=ni,nj
            cnt+=1
            arr[i][j]=cnt

        else:
            dr=(dr+1)%4
    print(f'#{tc}')
    for lst in arr:
        print(*lst)