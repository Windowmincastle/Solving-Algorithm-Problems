# import sys
# sys.stdin = open('input.txt','r')
from collections import deque

def bfs(s):
    q = deque()
    v = [0]*101

    q.append(s)
    v[s] = 1
    ans = s

    while q:
        cur = q.popleft()

        if v[ans] < v[cur] or (v[ans] == v[cur] and ans < cur):
            ans = cur

        for next in adj[cur]:
            if v[next] == 0:
                q.append(next)
                v[next] = v[cur] + 1

    return ans

T=10
for tc in range(1,T+1):

    n , s = map(int,input().split())
    lst = list(map(int,input().split()))
    adj = [[] for _ in range(101)]

    for i in range(0,len(lst),2):
        p,c = lst[i],lst[i+1]
        adj[p].append(c)

    ans = bfs(s)

    print(f'#{tc} {ans}')