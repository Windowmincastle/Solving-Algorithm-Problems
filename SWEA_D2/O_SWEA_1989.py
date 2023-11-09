'''
회문판별 문제.
파이썬 문자열 뒤집기를 하면 간단하게 풀수있다.
'''
T = int(input())
for tc in range(1,T+1):

    n = input()
    m = n[::-1]

    if n == m:
        print(f"#{tc} 1")
    else:
        print(f"#{tc} 0")
