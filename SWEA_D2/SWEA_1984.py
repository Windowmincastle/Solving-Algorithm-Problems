from collections import deque

T = int(input())
for tc in range(1,T+1):

    n = deque(map(int,input().split()))
    q = deque(sorted(n))
    result = 0
    q.pop()
    q.popleft()

    result = sum(q)/len(q) #처음에 여기서 sum(q)/len(q) 결과를 int로 바꿔서 result에 저장하ㅗ
    #print에서 round를 써버리니까 문제가 생겻던 것 같다
    print(f"#{tc} {round(result)}")# round는 두 번째 인자를 넣지 않으면 소수점 첫째자리에서 반올림한다.
