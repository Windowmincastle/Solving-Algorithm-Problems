import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        
        int diagonal = 0; // 현재 대각선 번호.
        int sum = 0; // 대각선 까지의 누적합
        
        //X가 포함된 대각선 번호 찾기
        while (sum < X) {
            diagonal++;
            sum += diagonal;
        }
        
        // X가 diagonal번째 대각선의 몇 번째 위치인지 계산하기.
        int position = X - ( sum - diagonal);
        
        // 대각선의 홀수/짝수에 따라 분수 계산
        int numerator, denominator;
        
        if (diagonal % 2 == 0 ) {
            //짝수 대각선
            numerator = position; // 분자 증가
            denominator = diagonal - position + 1; // 분모는 감소
        } else {
            //홀수 대각선
            numerator = diagonal - position + 1; // 분자는 감소
            denominator = position; //분모는 증가.
        }
        
        System.out.println(numerator + "/" + denominator);
    }
}