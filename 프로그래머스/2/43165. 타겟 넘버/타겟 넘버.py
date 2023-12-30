def dfs(numbers,target,cur_sum,cur_idx):

    if cur_idx == len(numbers):
        #타겟넘버가 만들어지는 경우
        if cur_sum == target:
            return 1
        else:
            return 0
    else:
        ans = 0
        # 노드를 dfs로 재귀적으로 탐색해서 결과를 구한다.
        ans += dfs(numbers,target,cur_sum+numbers[cur_idx],cur_idx+1)
        ans += dfs(numbers,target,cur_sum-numbers[cur_idx],cur_idx+1)
        return ans
def solution(numbers,target):
    ans = dfs(numbers,target,0,0)
    return ans