import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        
        // 방향 매핑
        Map<Character, int[]> move = new HashMap<>();
        move.put('U', new int[]{0, 1});
        move.put('D', new int[]{0, -1});
        move.put('R', new int[]{1, 0});
        move.put('L', new int[]{-1, 0});
        
        for (char dir : dirs.toCharArray()) {
            int nx = x + move.get(dir)[0];
            int ny = y + move.get(dir)[1];
            
            // 경계 체크
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            // 경로를 문자열로 양방향 동일하게 표현
            String path1 = x + "," + y + "→" + nx + "," + ny;
            String path2 = nx + "," + ny + "→" + x + "," + y;
            
            visited.add(path1);
            visited.add(path2);
            
            x = nx;
            y = ny;
        }
        
        // 한 길을 양방향으로 저장했으므로 절반만 세면 됨
        return visited.size() / 2;
    }
}
