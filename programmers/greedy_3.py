'''
프로그래머스 고득점 kit 큰 수 만들기 문제
1회 문제 풀이 날짜 - 12월 8일 금요일
'''
# 첫 번쨰 풀이, 틀림
def solution(number, k):
    # 1924 -> 리스트로 바꿔서
    lst = list(number)
    lst.sort()#오름차순 SORT
    while k != 0:
        lst.pop(0)
        k -= 1

    lst.sort(reverse=True)
    answer = ''.join(lst)

    return answer
# 참고 한 코드
def solution(number, k):

    answer = []  # Stack
    for num in number:
        while k > 0 and answer and answer[-1] < num:
            answer.pop()
            k -= 1
        answer.append(num)

    return ''.join(answer[:len(answer) - k])