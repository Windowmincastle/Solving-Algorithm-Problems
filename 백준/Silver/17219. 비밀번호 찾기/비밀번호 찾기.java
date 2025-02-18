import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, String> site = new HashMap<>();

        // N개의 사이트와 비밀번호 저장
        for (int i = 0; i < n; i++) {
            String[] ip = br.readLine().split(" ");
            site.put(ip[0], ip[1]);
        }

        // M개의 비밀번호 찾기
        for (int i = 0; i < m; i++) {
            String search = br.readLine();
            sb.append(site.get(search)).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}
