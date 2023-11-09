N = int(input())

for i in range(1,N+1):
    cnt = 0
    s = str(i)

    for check in s:
        if check == '3' or check == '6' or check == '9':
            cnt += 1

    if cnt == 0:
        print(i,end=' ')
    else:
        print(cnt * '-',end=' ')