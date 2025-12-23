import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static int[] numbers;
    static int[] operators = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    
    static void dfs(int sum,int idx) {
        // 언제까지 dfs를 반복해야할까?
        if (idx==n){
            
            MAX = Math.max(MAX,sum);
            MIN = Math.min(MIN,sum);
        
            return;
        }
        
        // 현재 숫자랑 다음 숫자랑 연산자 경우의수를 모두 dfs로 돌려
        for (int i=0; i<4; i++) {
            
            if ( operators[i] > 0) {
                operators[i]--;
                
                if ( i == 0) {
                    dfs(sum + numbers[idx], idx+1);
                } else if ( i == 1) {
                    dfs(sum - numbers[idx], idx+1);
                } else if ( i == 2) {
                    dfs(sum * numbers[idx], idx+1);
                } else if ( i == 3) {
                    dfs(sum / numbers[idx], idx+1);
                }
                operators[i]++;
                
            }

            
        }
    }
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for (int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int j=0; j<4; j++){
            operators[j] = Integer.parseInt(st.nextToken());
        }
        // dfs(첫번째숫자와,그다음숫자의 인덱스값)으로 호출
        dfs(numbers[0],1);
        
        System.out.println(MAX);
        System.out.println(MIN);
    }
}