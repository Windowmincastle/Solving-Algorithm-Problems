import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        
        boolean[] visited = new boolean[y+1];
        
        // BFS 큐, 현재 값과 연산 횟수를 함께 저장.
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 추가: 값 10, 연산횟수 0
        queue.offer(new int[] {x,0});
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            
            int[] current = queue.poll();
            int value = current[0];
            int count = current[1];
            
            if ( value == y ){
                return count;
            }
            
            int next1 = value + n;
            int next2 = value * 2;
            int next3 = value * 3;
            
            if (next1 <= y && !visited[next1]) {
                visited[next1] = true;
                queue.offer(new int[] {next1,count +1});
            }
            
            if (next2 <= y && !visited[next2]) {
                visited[next2] = true;
                queue.offer(new int[] {next2,count +1});
            }
            
            if (next3 <= y && !visited[next3]) {
                visited[next3] = true;
                queue.offer(new int[] {next3,count +1});
            }
            
        }
        
        return -1;

    }
}