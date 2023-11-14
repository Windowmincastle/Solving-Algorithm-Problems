'''
SWEA D4 1238 Contact
'''
import sys
sys.stdin = open('input.txt','r')
from collections import deque
def bfs(S):
    Q = deque()
    V = [0]*101 #방문처리테이블

    Q.append(S) #시작 좌표를 Q에 삽입
    V[S]=1 # 방문 처리
    ans = S # 시작점을 제외한 모든 사람에게 연락을 할수없는 경우를 대비

    while Q:
        c = Q.popleft() # 시작 좌표 = 현재 좌표
        # 방문 테이블의 ans 보다 현재 방문 테이블의 값이 더 크거나 = 가장 마지막에 연락을 받앗거나
        # ans랑 c도 가장 마지막에 연락을 받았는데=(표시를 거리를 +1씩 갱신하면서 했지?)
        # 현재 (ans=최대값) 값 보다 c 가 더 크다면
        # ans를 c로 바꾼다     #V[ans] == V[c] 갱신 테이블의 크기가 같은데 좌표가 더 크다 즉 최대값이다.
        if V[ans] < V[c] or ( V[ans] == V[c] and ans < c) :
            ans = c

        for n in adj[c]: # adj[현재좌표]랑 연결된 값들을 하나 씩 꺼내서
            if not V[n]: # 미방문된 곳 이라면?
                Q.append(n) #큐에 넣고
                V[n] = V[c]+1 # 연락 받은 순서를 기록

    return ans
T = 10
for tc in range(1,T+1):

    N , S = map(int,input().split())
    lst = list(map(int,input().split()))
    adj = [ [] for _ in range(101)] # 인접 리스트

    for i in range(0,len(lst),2): # 0부터 lst 길이만큼 2씩 커지면서
        p,c = lst[i],lst[i+1] # p랑 c 지역변수에 i랑 i+1 할당
        adj[p].append(c) # 인접 리스트표시
    ans = bfs(S) # 시작점 삽입

    print(f'#{tc} {ans}')