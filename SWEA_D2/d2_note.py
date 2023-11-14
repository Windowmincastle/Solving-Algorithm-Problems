import sys
sys.stdin=open('input.txt','r')

n = int(input())
tmp = '-'

for i in range(1,n+1):

    cnt = 0
    for j in str(i):
        if j=='3' or j=='6' or j=='9':
           cnt += 1

    if cnt == 0 :
        print(i,end=' ')
    else:
        print(cnt*tmp,end=' ')