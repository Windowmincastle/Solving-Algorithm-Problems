import sys
sys.stdin = open('input.txt','r')

S = list(map(int,input())) # str형 그대로 리스트에 저장되는거 주의
ans = 0
S.sort() # 정렬해놓은 상태

if S[0] == 0:
    first = S.pop(0) # 0 뽑기
    second = S.pop(0) # 두 번쨰 작은 수 뽑기
    ans = first + second # 더해서 ans에 저장

    S.reverse() # 내림차순 정렬
    for i in S: # 순서대로 ans 값에 곱하기
        ans *= i
else:
    first = S.pop(0)
    ans += first

    S.reverse()
    for i in S:
        ans *= i

print(ans)

# 아래는 나동빈님 코드
# data = input()
#
# # 첫 번째 문자를 숫자로 변경하여 대입
# result = int(data[0])
#
# for i in range(1, len(data)):
#     # 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
#     num = int(data[i])
#     if num <= 1 or result <= 1:
#         result += num
#     else:
#         result *= num
#
# print(result)