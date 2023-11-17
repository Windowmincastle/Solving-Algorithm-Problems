T = int(input())

for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    r = [int(input()) for _ in range(n)]
    w = [int(input()) for _ in range(m)]
    data = [int(input()) for _ in range(m * 2)]

    parked = [0] * n  # 0 means empty
    waiting = []
    result = 0

    for i in data:
        if i < 0:
            index = parked.index(abs(i))
            if waiting:
                j = waiting.pop(0)
                parked[index] = j
                result += r[index] * w[j - 1]
            else:
                parked[index] = 0

        else:
            if 0 not in parked:
                waiting.append(i)
            else:
                index = parked.index(0)
                parked[index] = i
                result += r[index] * w[i - 1]

    print(f'#{test_case} {result}')