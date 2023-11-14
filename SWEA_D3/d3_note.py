# import sys
# sys.stdin = open('input.txt','r')

T = 10
for tc in range(1,T+1):
    TC = input()
    arr = [ list(map(int,input().split())) for _ in range(100) ]
    arr_t = list(map(list,zip(*arr)))
    anslst = []

    for i in arr:
        anslst.append(sum(i))

    for j in arr_t:
        anslst.append(sum(j))

    tmp = 0
    for k in range(0,100):
        tmp += arr[k][k]
    anslst.append(tmp)

    tmp1 = 0
    for l in range(99,0,-1):
        tmp1 += arr[l][l]
    anslst.append(tmp1)

    print(f'#{tc} {max(anslst)}')