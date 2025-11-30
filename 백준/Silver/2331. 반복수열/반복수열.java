import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 숫자가 처음 등장한 순서를 저장하는 Map
        Map<Integer, Integer> map = new HashMap<>();
        
        int index = 0; // 등장 순서
        int current = A;

        while (true) {

            // 이미 등장한 적 있는 숫자 → 반복 시작
            if (map.containsKey(current)) {
                System.out.println(map.get(current));
                break;
            }

            // 숫자가 처음 등장했으므로 등장 위치 저장
            map.put(current, index++);
            
            // 다음 수 생성
            current = nextValue(current, P);
        }
    }

    // D[n] 계산 함수
    private static int nextValue(int num, int P) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, P);
            num /= 10;
        }

        return sum;
    }
}
