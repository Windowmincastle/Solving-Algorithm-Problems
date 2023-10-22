T = int(input())
for tc in range(1,T+1):

    n = int(input())
    data = list(map(int,input().split()))
    ml = list(reversed(sorted(data)))

    s = 0
    cnt = 0
    total = 0
    result = 0
    for i in range(len(data)):

        if data[i] == max(ml): # 파는 경우
            result = (max(ml)*cnt) - s
            total += result
            ml.remove(max(ml))
            s = 0
            cnt = 0
        elif data[i] < ml[0] : # 사는 경우
            s += data[i]
            cnt += 1

    print(f"#{tc} {total}")

