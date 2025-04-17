import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 자연수 N
        int K = sc.nextInt();  // K번째 약수
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {  // i가 N의 약수이면
                count++;       // 약수 개수 증가
                if (count == K) {
                    System.out.println(i);  // K번째 약수 출력
                    return;                 // 프로그램 종료
                }
            }
        }

        // 여기까지 왔다면 약수 개수가 K보다 적은 경우
        System.out.println(0);
    }
}
