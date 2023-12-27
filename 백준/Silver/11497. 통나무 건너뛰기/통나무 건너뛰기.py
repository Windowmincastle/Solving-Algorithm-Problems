T = int(input())
for _ in range(T):

    N = int(input())
    lst = list(map(int,input().split()))
    lst.sort()
    
    ans = 0
    for idx in range(2,N):
        ans = max(ans, abs(lst[idx] - lst[idx-2]))
    
    print(abs(ans))