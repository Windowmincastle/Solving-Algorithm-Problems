'''
11월13일 새벽 틀림 1회차
itertools 활용 방법 공부하기.
'''
# import sys
from itertools import combinations

# sys.stdin = open('input.txt', 'r')
T = int(input())
for tc in range(1, T + 1):
    # 문자열로 변환하여 입력값을 리스트로 저장
    lst = list(map(str, input()))
    # 데이터 리스트의 인덱스를 순차적으로 리스트로 저장
    target = [i for i in range(len(lst))]
    # 데이터를 문자열로 결합하고 정수로 변환하여 최솟값과 최댓값 초기화
    MIN = int(''.join(lst))
    MAX = int(''.join(lst))

    # 데이터 리스트에서 인덱스 2개를 선택하는 모든 조합에 대해 반복
    for value in combinations(target, 2):
        i, j = value  # 선택한 인덱스를 변수 i와 j에 저장
        lst[i], lst[j] = lst[j], lst[i]  # 데이터 리스트에서 i와 j 위치의 값을 서로 스왑
        if lst[0] == '0':  # 스왑 후 첫 번째 자리가 '0'이면,
            lst[i], lst[j] = lst[j], lst[i]  # 스왑을 다시 원상복구하고 다음 조합으로 넘어감
            continue

        #23행에서 초기화한 lst를 정수형으로 변환해서 현재 최솟값과 비교
        if int(''.join(lst)) < MIN:
            MIN = int(''.join(lst)) # 현재까지의 최솟값 업데이트
        #23행에서 초기화한 lst를 정수형으로 변환해서 현재 최댓값과 비교
        if int(''.join(lst)) > MAX:
            MAX = int(''.join(lst))  # 현재까지의 최댓값 업데이트
        lst[i], lst[j] = lst[j], lst[i]  # 스왑을 다시 원상복구 현재까지의 최대,최소가 정답이 아닐 수 있기 때문에 다시 원상태에서 평가해야한다.
    print(f'#{tc} {MIN} {MAX}')
