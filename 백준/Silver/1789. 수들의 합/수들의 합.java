import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();  // 입력값을 long으로 받습니다.
        int cnt = 0;
        long sum = 0;  // 합계를 long으로 처리합니다.
        int num = 1;

        while (true) {
            if (sum > S) break;
            
            sum += num;
            num++;
            cnt++;
        }

        System.out.println(cnt-1);
    }
}
