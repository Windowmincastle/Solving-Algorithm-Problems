from itertools import permutations
import math

def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def solution(numbers):
    lst = list(numbers)
    answer_set = set()

    for i in range(1, len(lst) + 1):
        for perm in permutations(lst, i):
            num = int(''.join(perm))
            if is_prime(num):
                answer_set.add(num)

    answer = len(answer_set)
    return answer