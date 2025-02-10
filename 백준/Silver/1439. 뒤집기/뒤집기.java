import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count0 = 0; // 0으로 바꾸는 경우의 횟수
        int count1 = 0; // 1로 바꾸는 경우의 횟수

        // 첫 번째 문자를 기준으로 초기화
        if (s.charAt(0) == '0') {
            count0++;
        } else {
            count1++;
        }

        // 문자열을 순회하며 연속된 숫자가 변하는 지점을 탐색
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                // 0 -> 1로 변환되는 경우
                if (s.charAt(i) == '0') {
                    count0++;
                } 
                // 1 -> 0로 변환되는 경우
                else {
                    count1++;
                }
            }
        }

        // 두 값 중 최소값을 출력
        System.out.println(Math.min(count0, count1));
    }
}
