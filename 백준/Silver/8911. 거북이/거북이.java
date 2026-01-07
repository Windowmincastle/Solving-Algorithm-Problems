import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        
        
        // 0 1 2 3 , 북 동 남 서
        int[] dx = {0, 1,  0, -1};
        int[] dy = {1, 0, -1, 0};
        
        while (TestCase > 0) {
            
            // 기저조건
            TestCase--;
            
            char[] coms = br.readLine().toCharArray();
            int maxX = 0, minX = 0;
            int maxY = 0, minY = 0;
            
            int curX = 0, curY = 0; // 현재 좌표 , 항상 0,0에서 시작
            int dir = 0; // 방향
            
            for (char com : coms) {
            
                //방향 변환만할때와, 이동할떄를 구분해야함.
                if ( com == 'F') {
                    //한 눈금 앞으로니까,현재 d와 좌표에서 이동하면되겟지?
                    curX += dx[dir];
                    curY += dy[dir];
                } else if ( com == 'B') {
                    // 한 눈금 뒤로니까, 현재 d와 좌표에서 한 눈금 뒤로 이동.
                    curX -= dx[dir];
                    curY -= dy[dir];
                } else if ( com == 'R') {
                    // 오른쪽으로 방향만 돌린다. 즉 동쪽으로 돌리는거지
                    dir = (dir + 1) % 4;
                } else if ( com == 'L') {
                    // 왼쪽으로 방향만 돌린다. 즉 서쪽으로 돌리는거지
                    dir = (dir + 3) % 4;
                }
                
                // 그리고 F나 B일때 최대,최소값들을 갱신해줘야함.
                
                if ( com == 'F' || com == 'B') {
                    
                    maxX = Math.max(maxX, curX);
                    minX = Math.min(minX, curX);
                    maxY = Math.max(maxY, curY);
                    minY = Math.min(minY, curY);
                }
                

            }
            // 직사각형 넓이 계산 밑변 x 높이
            int area = (maxX - minX) * (maxY - minY);
            System.out.println(area);
        }
    }
}