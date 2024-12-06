import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine()); // 명령어 개수
        HashSet<Integer> set = new HashSet<>(); // 집합 관리

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" "); // 명령어 입력
            String com = input[0]; // 명령어 추출

            // 숫자가 필요한 명령어 처리
            if (input.length == 2) {
                int x = Integer.parseInt(input[1]);

                switch (com) {
                    case "add":
                        set.add(x);
                        break;
                    case "remove":
                        set.remove(x);
                        break;
                    case "check":
                        sb.append(set.contains(x) ? "1\n" : "0\n");
                        break;
                    case "toggle":
                        if (set.contains(x)) {
                            set.remove(x);
                        } else {
                            set.add(x);
                        }
                        break;
                }
            }
            // 숫자가 필요 없는 명령어 처리
            else if (input.length == 1) {
                switch (com) {
                    case "all":
                        set.clear();
                        for (int j = 1; j <= 20; j++) {
                            set.add(j);
                        }
                        break;
                    case "empty":
                        set.clear();
                        break;
                }
            }
        }
        System.out.print(sb);
    }
}