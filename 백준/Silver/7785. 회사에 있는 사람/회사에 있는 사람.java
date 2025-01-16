import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashSet<String> employees = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            String name = log[0];
            String action = log[1];

            if (action.equals("enter")) {
                employees.add(name);
            } else {
                employees.remove(name);
            }
        }

        List<String> cnt = new ArrayList<>(employees);
        cnt.sort(Collections.reverseOrder());

        for (String employee : cnt) {
            sb.append(employee).append("\n");
        }

        System.out.print(sb);
    }
}
