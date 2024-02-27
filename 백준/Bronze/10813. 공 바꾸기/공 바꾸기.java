import java.util.*;

public class Main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // N: 바구니의 개수, M: 교환 횟수
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 바구니의 초기 상태 배열 생성.

        int[] baskets = new int[N];

        for (int i=0; i<N; i++){
            baskets[i] = i + 1;
        }

        //교환 횟수만큼 반복
        for (int k=0; k<M; k++){
            int i = scanner.nextInt() - 1;
            int j = scanner.nextInt() - 1;

            // 바구니 교환
            int temp = baskets[i];
            baskets[i] = baskets[j];
            baskets[j] = temp;
        }

        // 최종 바구니 상태 출력
        for (int ball : baskets) {
            System.out.print(ball + " ");
        }
        
    }
}