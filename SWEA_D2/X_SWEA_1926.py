'''
간단한 369 게임

'''
N= int(input())

for i in range(1,N+1):
    count = 0
    s = str(i) # i부터 N 까지 순차적으로 문자열로 캐스팅하고 s에 저장
    for i in s: # s에서 문자열 하나 씩 읽어서 3 ,6 ,9이면 count에 값을 저장
        if (i =='3') or (i =='6') or (i=='9'):
            count += 1

    if count == 0:
        print(i,end=' ')
    else:
        print(count * '-',end=' ')