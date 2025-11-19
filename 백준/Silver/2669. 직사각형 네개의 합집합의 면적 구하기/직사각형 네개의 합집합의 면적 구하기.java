import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[][] board = new int[101][101]; // 좌표 1~100 사용
        
        for (int i=0; i<4; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            // 직사각형 영역을 1로 채우기
            for(int x= x1; x< x2; x++){
                for(int y=y1; y<y2; y++){
                    board[x][y] = 1;
                }
            }
        }
        
        int area = 0;
        
        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){
                if(board[i][j] == 1){
                    area++;
                }
            }
        }
        
        System.out.println(area);
    }
}