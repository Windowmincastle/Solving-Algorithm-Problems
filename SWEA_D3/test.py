from itertools import combinations
'''
지금은 경우의 수가 9가지에서 7가지를 뽑아서 합이 100인 것 을 찾으면 되지만
만약 만명 중 에서 구천명을 뽑아서 합이 x인 것을 찾는다면?
시간 복잡도는 어마무시하게 올라갈 것 이다. 그렇다면 역 으로 생각한다면 구천명을 뽑아서 계산하지말고
천명만 뽑아서 찾는다면 더 빠를 것 그렇다면 이런 식 으로 코드를 짤수있다.
또 복잡하게 다중 루프를 탈출할 때 함수를 짜서 바로 return하는 형식으로한다면
break를 어디서 써야할지 고민하지 않을 수 있다.
'''
def solve():

    N = 2
    target = sum(lst) - 100
    for val in combinations(lst,N):
        if sum(val) == target:
            # print(val)
            return val

lst = [int(input()) for _ in range(9)]
n,m = solve()

for i in sorted(lst):
    if i != n  and i != m:
        print(i)