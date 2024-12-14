import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][m];

        for (int i=0; i<n; i++){
            
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
        
                A[i][j] = Integer.parseInt(st.nextToken());
        
            }
        
        }

        st = new StringTokenizer(br.readLine());
        
        int m2 = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int B[][] = new int[m2][k];

        for(int i=0; i<m2; i++){
            
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<k; j++){
                
                B[i][j] = Integer.parseInt(st.nextToken());

            }
        }


        //행렬 곱셈 결과 계산
        int[][] C = new int[n][k];

        for (int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                for(int p=0; p<m; p++){
                    
                    C[i][j] += A[i][p] * B[p][j];
                
                }
            }
        }

        // 결과 출력
        for (int i = 0; i<n; i++){
            for (int j=0; j<k; j++){
                sb.append(C[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
    
}
