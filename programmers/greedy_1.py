'''
고득점 kit 그리디 , 체육복 문제
틀렷음, 다시 풀기 - 12월 6일 수요일

- 힌트
제약사항을 잘 읽자. 정당성을 잘 생각해봐라.

'''
def solution(n, lost, reserve):

    set_reserve = set(reserve) - set(lost)
    set_lost = set(lost) - set(reserve)
    answer = 0
    for i in lost: # [2,4]순서

        tmp1 = i + 1 # 3
        tmp2 = i - 1 # 1

        for j in reserve:
            if tmp1 == j: # [1,3,5] 순서
                lost.pop(0)
                print(lost)
                continue
            elif tmp2 == j:
                lost.pop(0)

    answer = n - len(lost)
    return answer
# 참고 후 코드
def solution(n,lost,reserve):

    #전처리 과정
    set_reserve = set(reserve) - set(lost)
    set_lost = set(lost) - set(reserve)

    for i in set_reserve: # set 형식도 이처럼 접근이 가능하다.
            if i-1 in set_lost: #이렇게 바로 처리하는게 좋은 것 같다.
                    set_lost.remove(i-1)
            elif i+1 in set_lost:
                    set_lost.remove(i+1)

    return n-len(set_lost)