# import sys
# sys.stdin=open('input.txt','r')
'''
참고 블로그
https://velog.io/@kcs05008/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%91%90-%EC%9A%A9%EC%95%A1-%EB%B0%B1%EC%A4%80-2470-python
'''
n = int(input())
arr = list(map(int, input().split()))
arr.sort()

left = 0
right = n - 1

answer = abs(arr[left] + arr[right])
final = [arr[left], arr[right]]

while left < right:
    left_val = arr[left]
    right_val = arr[right]

    sum = left_val + right_val

    if abs(sum) < answer:
        answer = abs(sum)
        final = [left_val, right_val]
        if answer == 0:
            break
    if sum < 0:
        left += 1
    else:
        right -= 1

print(final[0], final[1])
