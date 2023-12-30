n = int(input())
lst = list(map(int, input().split()))
lst.sort()

L = 0
R = n-1
#첫 값으로 맨 왼쪽과 오른쪽을 더한 값의 절대값을 넣어준다.
tmp = abs(lst[L] + lst[R])
#정답 처리를 위해서 현재 값의 쌍을 ans 리스트에 저장
ans = [lst[L], lst[R]]


while L < R:

    left_val = lst[L]
    right_val = lst[R]

    sum = left_val + right_val

    # 현재 tmp 보다 작은 값을 찾으면 진입
    if abs(sum) < tmp:
        tmp = abs(sum)
        ans = [left_val, right_val] # 정답처리를 위해서 현재보다 작은 값이 있다면 갱신
        # tmp가 0이면 best case이기 때문에 break
        if tmp == 0:
            break

    # 0에 가깝게 만들어주기 위해서 left와 right의 위치를 0을 기준으로 갱신해준다.
    if sum < 0:
        L += 1
    else:
        R -= 1

print(ans[0], ans[1])
