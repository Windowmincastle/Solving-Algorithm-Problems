# import sys
# sys.stdin=open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    n = int(input())
    dtc = 0
    spe = 0

    for i in range(n):
        com = list(map(int,input().split()))
        #가속
        if com[0] == 1:
            spe += com[1]
        #감속
        elif com[0] == 2:
            if spe > com[1]:
                spe -= com[1]
            else:
                spe = 0
        dtc += spe

    print(f'#{tc} {dtc}')