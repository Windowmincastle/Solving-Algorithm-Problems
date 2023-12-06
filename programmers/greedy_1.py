'''
고득점 kit 그리디 , 체육복 문제
'''
def solution(n, lost, reserve):
    answer = 0
    for i in lost: # [2,4]순서
        tmp1 = i + 1
        tmp2 = i - 1
        for j in reserve:
            if tmp1 == j: # [1,3,5] 순서
                lost.pop(0)
                continue
            elif tmp2 == j:
                lost.pop(0)

    answer = n - len(lost)

    return answer

n = 5
lost = [2,4]
reserve = [1,3,5]
solution(n,lost,reserve)