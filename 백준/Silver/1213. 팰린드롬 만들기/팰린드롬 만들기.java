import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        
        // 1. 문자 빈도수 세기
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // 2. 홀수 개수의 문자 확인
        int oddCount = 0;
        char oddChar = 0;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
                oddChar = entry.getKey();
            }
        }
        
        // 홀수 개수의 문자가 두 개 이상이면 회문을 만들 수 없음
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        // 3. 반쪽 문자열 만들기
        TreeSet<Character> sortedChars = new TreeSet<>(charCount.keySet());
        StringBuilder half = new StringBuilder();
        for (char c : sortedChars) {
            int count = charCount.get(c);
            for (int i = 0; i < count / 2; i++) {
                half.append(c);
            }
        }
        
        // 4. 회문 구성
        String halfStr = half.toString();
        String reverseHalfStr = half.reverse().toString();
        
        if (oddCount == 1) {
            System.out.println(halfStr + oddChar + reverseHalfStr);
        } else {
            System.out.println(halfStr + reverseHalfStr);
        }
    }
}
