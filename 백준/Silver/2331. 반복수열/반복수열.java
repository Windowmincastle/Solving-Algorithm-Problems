import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int P = sc.nextInt();
        sc.close();
        
        // 0~9의 P제곱을 미리 계산
        int[] pow = new int[10];
        for (int d = 0; d <= 9; d++) {
            pow[d] = (int) Math.pow(d, P);
        }
        
        // 수 → 등장 순서를 저장하는 맵
        Map<Integer, Integer> order = new HashMap<>();
        int cur = A;
        int idx = 1;
        order.put(cur, idx);
        
        while (true) {
            // cur의 각 자리 숫자 P제곱합 계산
            int next = 0;
            int tmp = cur;
            while (tmp > 0) {
                next += pow[tmp % 10];
                tmp /= 10;
            }
            
            idx++;
            if (order.containsKey(next)) {
                // next가 처음 등장한 순서에서 1을 빼면, 반복 부분이 시작되기 전까지 남는 수의 개수
                System.out.println(order.get(next) - 1);
                break;
            } else {
                order.put(next, idx);
                cur = next;
            }
        }
    }
}
