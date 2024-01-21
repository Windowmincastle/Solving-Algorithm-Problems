import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        int len = word.length();// String 클래스의 문자열은 length();로 사용해야한다.
        int ans = 1;
        // level을 charAt 함수를 사용해서
        // [0]번째의 l과 [4]번째의 l을 비교
        // [1]번째의 e와 [3]번째의 e를 비교
        // 만약 다른 것이 있다면 펠린드롬이 아니기 때문에 ans를 0으로 바꾸고 출력.
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - 1 - i)) {
                ans = 0;
            }
        }

        System.out.println(ans);
    }
}