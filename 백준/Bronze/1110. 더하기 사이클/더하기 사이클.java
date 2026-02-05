import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        String targetStr = br.readLine();
        // 한 자리 수일 때 "05"처럼 만들어주는 작업
        if (Integer.parseInt(targetStr) < 10) {
            targetStr = "0" + targetStr;
        }
        
        int targetNumber = Integer.parseInt(targetStr);
        int returnNumber = -1; // 처음 비교 시 무조건 다르도록 -1로 초기화
        
        String currentStr = targetStr; // 루프 안에서 계속 변할 값

        while (targetNumber != returnNumber) {
            count++;
            
            // 1. 현재 문자열을 쪼개기
            char[] numberCut = currentStr.toCharArray();
            
            // 2. 왼쪽 수, 오른쪽 수 구하기
            int leftNum = numberCut[0] - '0';
            int rightNum = numberCut[1] - '0';
            
            // 3. 합 구하기
            int tempSum = leftNum + rightNum;
            
            // 4. 새로운 수 만들기 (String 방식 유지)
            // 주어진 수의 오른쪽 수 + 합의 오른쪽 수
            String newNum = String.valueOf(rightNum) + String.valueOf(tempSum % 10);
            
            // 5. 비교를 위해 숫자로 변환 및 다음 루프 준비
            returnNumber = Integer.parseInt(newNum);
            
            // 6. 다음 루프를 위해 currentStr 갱신 (항상 두 자리 유지)
            if (returnNumber < 10) {
                currentStr = "0" + returnNumber;
            } else {
                currentStr = newNum;
            }
        }
        
        System.out.println(count);
    }
}