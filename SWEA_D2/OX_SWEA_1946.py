'''

꼭 다시 풀기 - 현재 날짜 11월 5일 - 노션에 정리햇음.

'''
import sys
sys.stdin = open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    N = int(input())
    text =""
    for _ in range(N):
        word,number = input().split()
        text += word * int(number)

    print(f'#{tc}')
    for j in range(0,len(text),10):
        print(text[j:j+10])
