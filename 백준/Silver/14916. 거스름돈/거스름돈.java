import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 거스름돈 액수 입력
        
        int count = -1; // 동전 개수 초기화
        
        // 5원짜리를 최대한 많이 사용하면서 남은 금액이 2로 나누어떨어지는지 확인
        for (int i = n / 5; i >= 0; i--) {
            int remaining = n - (i * 5); // 5원짜리 사용 후 남은 금액
            if (remaining % 2 == 0) { // 남은 금액이 2로 나누어떨어지면
                count = i + (remaining / 2); // 5원짜리 개수 + 2원짜리 개수
                break;
            }
        }
        
        System.out.println(count);
    }
}
