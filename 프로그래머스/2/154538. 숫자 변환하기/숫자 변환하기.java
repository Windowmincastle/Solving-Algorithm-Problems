import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        // 방문 여부 체크(중복 탐색 방지)
        boolean[] visited = new boolean[y+1];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,0}); // {현재값, 연산 횟수}
        visited[x] = true;
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            int value = cur[0];
            int cnt = cur[1];
            
            if (value == y ) return cnt;
            
            // 다음 상태 3가지
            int[] nextValues = {value + n, value * 2, value * 3};
            
            for (int next : nextValues) {
                
                // 범위 체크 + 방문 체크
                if(next <= y && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next,cnt+1});
                }
                
            }
            
        }
        
        return -1;
    }
}