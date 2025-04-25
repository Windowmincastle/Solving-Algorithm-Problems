import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();

        // '-' 기호를 기준으로 분리
        String[] minusSplit = expression.split("-");

        // 첫 번째 그룹은 그냥 더함
        int result = sumOfExpression(minusSplit[0]);

        // 나머지는 괄호로 묶어서 뺌
        for (int i = 1; i < minusSplit.length; i++) {
            result -= sumOfExpression(minusSplit[i]);
        }

        System.out.println(result);
    }

    // "50+40" 같은 문자열을 파싱해서 숫자 합계를 리턴
    private static int sumOfExpression(String expr) {
        String[] plusSplit = expr.split("\\+");
        int sum = 0;
        for (String num : plusSplit) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
