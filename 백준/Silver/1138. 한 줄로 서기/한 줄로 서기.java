import java.io.*;
import java.util.*;

public class Main {

    /*
     
     */

    public static void main(String[] args) throws Exception{

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 사람 수
        
        int[] tallerCount = new int[n]; // 자신보다 키큰 사람 수
        int[] result = new int[n]; // 줄 선 순서.
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            tallerCount[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            
            int cnt = tallerCount[i];

            for (int j = 0; j<n; j++){
                // 빈 자리가 cnt만큼 지나가면 현재 사람을 배치한다.
                if (cnt == 0 && result[j] == 0 ){
                    
                    result[j] = i+1;
                    break;
                }
                //빈자리 발견시 cnt를 감소
                if ( result[j] == 0 ){
                    cnt--;
                }
            }

        }
        
        for (int r : result ) {
            sb.append(r).append(" ");

        }

        System.out.println(sb);

    }
}
