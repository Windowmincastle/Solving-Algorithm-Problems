from itertools import permutations
import math

def is_prime(num):
    """
    주어진 숫자가 소수인지 판별하는 함수
    :param num: 판별할 숫자
    :return: 소수이면 True, 아니면 False
    """
    if num < 2:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def solution(numbers):
    """
    주어진 숫자로 만들 수 있는 소수의 개수를 반환하는 함수
    :param numbers: 주어진 숫자 문자열
    :return: 주어진 숫자로 만들 수 있는 소수의 개수
    """
    lst = list(numbers) # 입력된 숫자를 각 자리 수로 분리하여 리스트에 저장
    answer_set = set() # 중복을 방지하기위해 set() 자료형 활용

    # 1부터 리스트의 길이까지 숫자로 이루어진 순열을 생성하기 위한 반복문
    for i in range(1, len(lst) + 1):
        # 현재 길이 i로 생성 가능한 순열 생성
        for perm in permutations(lst, i):
            num = int(''.join(perm))  # 현재 순열을 숫자로 변환
            if is_prime(num):  # 소수인지 확인 True를 return 받으면 진입.
                answer_set.add(num)  # 소수면 집합에 추가

    answer = len(answer_set)
    return answer

# 테스트
# numbers = '17'
# result = solution(numbers)
# print('test 1 ->' ,result)
# numbers = "110"
# result = solution(numbers)
# print('test 2 ->',result)