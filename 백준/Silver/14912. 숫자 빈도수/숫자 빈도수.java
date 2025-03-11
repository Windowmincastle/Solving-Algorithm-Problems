import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int n = sc.nextInt();
        char d = sc.next().charAt(0);  // 한 자리 숫자 d (문자로 받기)
        
        int count = 0;
        
        // 1부터 n까지 확인
        for (int i = 1; i <= n; i++) {
            // 현재 숫자를 문자열로 변환
            String numStr = Integer.toString(i);
            
            // 해당 숫자 d가 numStr에 포함된 횟수 세기
            for (int j = 0; j < numStr.length(); j++) {
                if (numStr.charAt(j) == d) {
                    count++;
                }
            }
        }
        
        // 결과 출력
        System.out.println(count);
    }
}
