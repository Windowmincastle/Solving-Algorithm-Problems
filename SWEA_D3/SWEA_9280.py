import sys
sys.stdin=open('input.txt','r')

T = int(input())
for tc in range(1, T + 1):
    n, m = map(int,input().split())
    r = [int(input()) for _ in range(n)] #  단위 무게당 주차 공간 요금
    w = [int(input()) for _ in range(m)] #  차량 무게
    line = [int(input()) for _ in range(m * 2)] # 순서
    p_s = [0] * n # 주차 공간 리스트
    wait = [] # 대기줄
    ans = 0

    for i in line:
        if i < 0 : # 주차장 out = 음수
            idx = p_s.index(abs(i)) # 절대값으로 변환 후 -> 빈 자리를 idx에 저장
            if wait: # 만약 대기하는 사람이 있으면 진입
                j = wait.pop(0) # j에 대기 순번대로 뽑아서
                p_s[idx] = j # 방금 빈 자리에 j 저장
                ans += r[idx] * w[j-1] # 요금 정산
            else: #대기자 없으면 주차 자리 만들어 놓기
                p_s[idx] = 0
        else:# 주차장 in = 양수
            if 0 not in p_s: # 빈 자리 없으면
                wait.append(i) # 대기 줄로
            else: # 빈 자리 있으면
                idx = p_s.index(0) # 빈 자리 인덱스를 idx에 저장
                p_s[idx] = i # 주차장 빈 자리에 i 주차
                ans += r[idx] * w[i-1] # 정산

    print(f'#{tc} {ans}')