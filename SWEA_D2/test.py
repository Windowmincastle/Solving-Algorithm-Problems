import sys
sys.stdin = open('input.txt','r')

T = int(input())

for tc in range(1,T+1):

    N = int(input())

    text=""
    for i in range(N):

        word , cnt = input().split()
        text += word*int(cnt)

    print(f'#{tc}')
    for j in range(0,len(text),10):
        print(text[j:j+10])