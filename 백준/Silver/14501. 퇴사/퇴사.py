def dfs(day,total):
    global ans
    # 종료 조건에 도달하면 모든 경우의 수 에서 가장 큰 값을 ans에 저장하자
    if day >= N:
        ans = max(ans,total)
        return

    # [1]번 상담하는 경우 현재 날짜 + 상담 소요 기간 <= 퇴사일 범위 내
    # 상담 하는 경우는 항상 가능하지 않기 때문에 N 범위안에 있는 경우만 if문에 진입하자
    if day + data[day] <= N:
        # 현재 날짜 + 소요기간 , pay + 누적
        dfs(day + data[day], total + pay[day])
    # [2] -> 상담하지 않는경우는 항상 가능하다.
    # 상담 안하면 day에서 다음 날로 넘어간다, 상담을 안했기 때문에 total 금액은 그대로 둔다.
    dfs(day+1,total)

N = int(input())
data = [0] * N # 날짜
pay = [0] * N # 페이

for i in range(N):
    data[i],pay[i] = map(int,input().split()) # 입력 처리

ans = 0
#모든 경우의 수를 dfs로 탐색하자
dfs(0,0)
print(ans)