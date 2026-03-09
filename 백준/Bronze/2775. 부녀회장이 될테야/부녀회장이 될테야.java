import java.io.*;
import java.util.*;

class Main {
    
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        int[][] apt = new int[15][15];
        // 0층 초기화
        for (int i=1; i<=14; i++) {
            apt[0][i] = i;
        }
        
        //아파트 전체 계산
        for(int floor = 1; floor <= 14; floor++) {
            for (int room = 1; room <= 14; room++) {
                int sum = 0;
                
                for (int i = 1; i<=room; i++) {
                    sum += apt[floor -1][i];
                }
                apt[floor][room] = sum;
            }
        }
                // 테스트 케이스
        for (int t = 0; t < T; t++) {

            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(apt[k][n]);
        }
    }
}