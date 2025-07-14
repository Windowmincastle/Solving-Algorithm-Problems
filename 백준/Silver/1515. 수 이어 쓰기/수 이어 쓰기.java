import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String remain = sc.nextLine(); // 지우고 남은 수

        int N = 1;
        int idx = 0; // remain에서 현재 비교할 인덱스

        while (idx < remain.length()) {
            String current = String.valueOf(N);
            int curIdx = 0; // current 숫자에서 비교할 인덱스

            // remain 문자열을 current 숫자와 매칭하면서 인덱스를 진행함
            while (curIdx < current.length() && idx < remain.length()) {
                if (current.charAt(curIdx) == remain.charAt(idx)) {
                    idx++;
                }
                curIdx++;
            }
            N++;
        }

        System.out.println(N-1); // 마지막으로 증가시킨 N은 불필요하므로 1을 빼줌
    }
}
