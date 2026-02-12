import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] lights = new int[M];
        
        for (int i = 0; i < M; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        
        // 1. 시작 구간
        answer = Math.max(answer, lights[0]);
        
        // 2. 가로등 사이 구간
        for (int i = 1; i < M; i++) {
            int gap = lights[i] - lights[i - 1];
            int needed = (gap + 1) / 2;  // ceil(gap / 2)
            answer = Math.max(answer, needed);
        }
        
        // 3. 마지막 구간
        answer = Math.max(answer, N - lights[M - 1]);
        
        System.out.println(answer);
    }
}
