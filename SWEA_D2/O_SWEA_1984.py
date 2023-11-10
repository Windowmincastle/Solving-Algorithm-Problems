'''
2번 풀엇음  - 날짜 11월 10일 금
쉬워서 다시 안 봐도 될듯

'''
from collections import deque
T = int(input())
for tc in range(1,T+1):

    n = deque(map(int,input().split())) # 덱 자료형으로 받는다
    q = deque(sorted(n)) # 정렬한다
    result = 0
    q.pop() # 오른쪽 제거 = 가장 큰 값
    q.popleft() # 왼쪽 제거 = 가장 작은 값

    result = sum(q)/len(q) #처음에 여기서 sum(q)/len(q) 결과를 int로 바꿔서 result에 저장하ㅗ
    #print에서 round를 써버리니까 문제가 생겻던 것 같다
    print(f"#{tc} {round(result)}")# round는 두 번째 인자를 넣지 않으면 소수점 첫째자리에서 반올림한다.

'''
2번쨰 풀이 코드
import sys
from collections import deque
sys.stdin = open('input.txt','r')

T = int(input())
for tc in range(1,T+1):

    lst = deque(map(int,input().split()))
    tmp = deque(sorted(lst)) # 오름차순 정렬
    #앞,뒤 제거
    tmp.popleft()
    tmp.pop()

    ans = round(sum(tmp)/len(tmp))
    
    print(f'#{tc} {ans}')
'''