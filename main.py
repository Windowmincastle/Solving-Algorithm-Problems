T = int(input())
for tc in range(1,T+1):

    n = int(input())
    ary = [False] * 10
    i = 1
    cnt = 0
    while cnt != 10:

        sleep = str(n*i)

        for j in sleep:
            if ary[int(j)] == False:
                ary[int(j)] = True
                cnt +=1
        i += 1
    print("#{} {}".format(tc,n*(i-1)))
