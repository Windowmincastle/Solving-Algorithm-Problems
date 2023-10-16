import math
TC = int(input())

for test_case in range(1,TC+1):

    a,b = map(int,input().split())
    cnt = 0

    for i in range(a,b+1):
        r = math.sqrt(i)

        if r == int(r): # i의 제곱근이 정수일때만 정수 비교
            i = str(i) # 캐스팅
            r = str(int(r)) # 캐스팅

            if i == i[::-1] and r == r[::-1]: #펠린드롬 판별
                cnt += 1

    print(f"#{test_case} {cnt}")