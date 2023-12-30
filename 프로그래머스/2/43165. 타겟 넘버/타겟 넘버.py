# target -> 만들고자 하는 숫자
# cur_sum -> 현재 까지의 숫자가 몇 인지 담는 변수
# cur_idx -> 내가 지금 몇 번째 숫자를 더 하고 뺄 건지 담는 변수
# cur_sum+numbers[cur_idx] -> 이전 까지 연산한 value + 현재 계산할 value + 방향
# cur_sum-numbers[cur_idx] -> 이전 까지 연산한 value + 현재 계산할 value - 방향
def dfs(numbers,target,cur_sum,cur_idx):

    if cur_idx == len(numbers): # Depth의 끝에 도달하면 len(numbers)와 cur_idx가 같기 때문에 if문 진입
        #타겟넘버가 만들어지는 경우
        if cur_sum == target:
            return 1 # 17,18행의 재귀 함수의 호출 값을 return
        else:
            return 0 # depth 끝 까지 갔지만 타겟넘버를 만들지 만들지 못 하는 경우
    else: # 도달하지 못 했다면 else문 진입
        ans = 0  # 경우의 수를 담을 변수
        # 노드를 dfs로 재귀적으로 탐색해서 결과 ans에 더한다.
        ans += dfs(numbers,target,cur_sum+numbers[cur_idx],cur_idx+1)
        ans += dfs(numbers,target,cur_sum-numbers[cur_idx],cur_idx+1)

        return ans
def solution(numbers,target):
    ans = dfs(numbers,target,0,0)
    return ans