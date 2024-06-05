import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine()); // 총 가격
        int buycnt = 9; // 10권을 샀지만 1개의 가격은 모른다. 예제에서도 주어지지 않는다.
        while (buycnt > 0) {
            int book = Integer.parseInt(br.readLine());
            total -= book;
            buycnt--;
        }
        System.out.println(total);
    }
}