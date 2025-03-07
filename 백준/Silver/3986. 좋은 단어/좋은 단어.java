import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 단어의 개수
        int goodWordCount = 0;

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            if (isGoodWord(word)) {
                goodWordCount++;
            }
        }

        System.out.println(goodWordCount);
        sc.close();
    }

    public static boolean isGoodWord(String word) {
        Stack<Character> stack = new Stack<>();

        for (char ch : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();  // 같은 문자면 짝을 지어 제거
            } else {
                stack.push(ch);  // 아니면 스택에 추가
            }
        }

        return stack.isEmpty();  // 스택이 비어있으면 좋은 단어
    }
}
