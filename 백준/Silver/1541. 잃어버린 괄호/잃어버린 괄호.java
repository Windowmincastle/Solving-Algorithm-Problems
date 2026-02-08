import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        // '-' 기준으로 분리
        String[] minusSplit = expression.split("-");

        int result = 0;

        // 첫 번째 덩어리는 그대로 더함
        String[] first = minusSplit[0].split("\\+");
        for (String num : first) {
            result += Integer.parseInt(num);
        }

        // 두 번째 덩어리부터는 전부 빼기
        for (int i = 1; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            int sum = 0;
            for (String num : plusSplit) {
                sum += Integer.parseInt(num);
            }
            result -= sum;
        }

        System.out.println(result);
    }
}
