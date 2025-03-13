import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 토핑 개수 입력

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> cheeseSet = new HashSet<>(); // 중복 방지를 위한 집합

        while (st.hasMoreTokens()) {
            String topping = st.nextToken();
            if (topping.endsWith("Cheese")) { // "Cheese"로 끝나는지 확인
                cheeseSet.add(topping);
            }
        }

        // 치즈 종류가 4개 이상이면 yummy, 아니면 sad 출력
        System.out.println(cheeseSet.size() >= 4 ? "yummy" : "sad");
    }
}
