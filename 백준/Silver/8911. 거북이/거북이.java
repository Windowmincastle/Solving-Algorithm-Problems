import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스에 대해서 거북이가 이동한 영역을 모두 포함하는 가장 작은 직사각형
        int answer = 0;
        
        // 방향 이동 벡터
        // 0 : 북 , 1: 동, 2: 남, 3: 서
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        // 테스트케이스 수 만큼 반복.
        for (int t=0; t<T; t++) {
            
            char[] commands = br.readLine().toCharArray();
            
            int x = 0, y = 0;
            int minX = 0, maxX = 0;
            int minY = 0, maxY = 0;
            
            int currentX = 0;
            int currentY = 0;
            // 시작은 북쪽 
            int dir = 0;
            
            for (char cmd : commands) {
                
                if ( cmd == 'L') {
                    dir = (dir + 3) % 4;
                } else if ( cmd == 'R') {
                    dir = (dir + 1) % 4;
                } else if ( cmd == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                } else if ( cmd == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                }
                
                if ( cmd == 'F' || cmd =='B') {
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
                
            }
            
            int area = (maxX - minX) * (maxY - minY);
            System.out.println(area);
        }
    }
}