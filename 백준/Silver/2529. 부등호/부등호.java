import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static char[] inequality;
    static boolean[] visited = new boolean[10];
    static String min = null;
    static String max = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        inequality = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            inequality[i] = st.nextToken().charAt(0);
        }

        backtrack(0, "");

        System.out.println(max);
        System.out.println(min);
    }

    static void backtrack(int depth, String number) {

        if (depth == k + 1) {
            if (min == null || number.compareTo(min) < 0) {
                min = number;
            }
            if (max == null || number.compareTo(max) > 0) {
                max = number;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {

                if (depth == 0 || valid(number.charAt(depth - 1) - '0', i, inequality[depth - 1])) {
                    visited[i] = true;
                    backtrack(depth + 1, number + i);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean valid(int a, int b, char op) {
        if (op == '<') return a < b;
        else return a > b;
    }
}
