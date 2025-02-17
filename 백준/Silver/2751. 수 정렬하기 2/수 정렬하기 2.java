import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에 수의 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // N개의 수를 저장할 배열 생성
        int[] numbers = new int[N];
        
        // N개의 수 입력받기
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        // 오름차순 정렬
        Arrays.sort(numbers);
        
        // 결과를 빠르게 출력하기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append(num).append('\n');
        }
        
        // 출력
        System.out.print(sb.toString());
    }
}
