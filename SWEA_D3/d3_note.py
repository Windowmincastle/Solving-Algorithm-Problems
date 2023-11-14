import sys
sys.stdin=open('input.txt','r')
T = int(input())
# 정렬을 위한 딕셔너리
n_dict = {"ZRO": 0, "ONE": 1, "TWO": 2, "THR": 3, "FOR": 4, "FIV": 5, "SIX": 6, "SVN": 7, "EGT": 8, "NIN": 9}
for test_case in range(1, T + 1):

    tc , lst = input().split()
    lst=list(map(str,input().split()))

    lst.sort(key=lambda value : n_dict[value])
    print(tc)
    print(' '.join(lst))