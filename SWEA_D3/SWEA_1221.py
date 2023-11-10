import sys
sys.stdin = open('input.txt','r')

T = int(input())
for k in range(1,T+1):

    tc, leng = input().split()
    lst = list(input().split())
    ZRO = []
    ONE = []
    TWO = []
    THR = []
    FOR = []
    FIV = []
    SIX = []
    SVN = []
    EGT = []
    NIN = []

    for i in range(int(leng)):
        if lst[i] == 'ZRO':
            ZRO.append(lst[i])
        elif lst[i] =='ONE':
            ONE.append(lst[i])
        elif lst[i] == 'TWO':
            TWO.append(lst[i])
        elif lst[i] == 'THR':
            THR.append(lst[i])
        elif lst[i] == 'FOR':
            FOR.append(lst[i])
        elif lst[i] == 'FIV':
            FIV.append(lst[i])
        elif lst[i] == 'SIX':
            SIX.append(lst[i])
        elif lst[i] == 'SVN':
            SVN.append(lst[i])
        elif lst[i] == 'EGT':
            EGT.append(lst[i])
        elif lst[i] == 'NIN':
            NIN.append(lst[i])

    ans = []
    ans = ZRO + ONE + TWO + THR + FOR + FIV + SIX + SVN + EGT + NIN
    print(f'{tc}')
    print(*ans)