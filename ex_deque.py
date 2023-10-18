from collections import deque

n = deque(map(int,input().split()))

print(deque)
print(type(n))

for _ in range(1,10+1):
    n.popleft()
    n.pop()

    print(n)