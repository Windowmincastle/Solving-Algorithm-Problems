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