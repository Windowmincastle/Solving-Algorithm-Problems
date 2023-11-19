'''
패턴 마디의 길이
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5P1kNKAl8DFAUq&categoryId=AV5P1kNKAl8DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1&&&&&&&&&&

'''

import sys
sys.stdin = open('input.txt','r')


T = int(input())
for tc in range(1,T+1):

    S = input()
    for i in range(1,10):
        print(f'i -> {i} , s[:i] => {S[:i]}',end=' ') # 찍어보기
        print(f' S[i:2*i] ->{S[i:2*i]}',end=' ') # 찍어보기
        if S[:i] == S[i:2*i]:
            print(f'#{tc} {i}')
            break
