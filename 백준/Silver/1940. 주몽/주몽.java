import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int targetValue = Integer.parseInt(br.readLine());
        
        int[] ary = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(ary);
        
        int answer = 0;
        int left = 0;
        int right = n-1;
        
        while (left < right) {
            
            int sum = ary[left] + ary[right];
            
            // sum이 targetValue보다 크다 그럼 어쨰야겟어? 정렬을 했으니까, left의 포인터 위치를 이동을
            // 해야겟지? 정렬을 했으니 큰값을 담당하는 right의 포인터 위치를 옮겨야겠지.
            if ( sum > targetValue ) {
                right--;
            // sum이 타겟 값 보다 작다면, 더 큰값들을 합쳐서 비교해봐야겟지, 이미 right는 큰값으로 잡혀있으니
            // left를 이동시켜서 더 큰값으로 만들어야한다.
            } else if (sum < targetValue) {
                left++;
            } else if ( sum == targetValue ) {
                //정답 조합이기 때문에 answer ++하고
                //양쪽 다 한칸씩 좁혀준다.
                answer++;
                left++;
                right--;
            }
            
        }
        System.out.println(answer);
        
    } 
}