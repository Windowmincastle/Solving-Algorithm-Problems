import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            meetings[i][0] = sc.nextInt(); // 시작 시간
            meetings[i][1] = sc.nextInt(); // 종료 시간
        }

        // 종료 시간 기준으로 정렬, 종료 시간이 같다면 시작 시간 기준으로 정렬
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });

        int count = 0;
        int lastEndTime = 0;

        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= lastEndTime) {
                count++;
                lastEndTime = meetings[i][1];
            }
        }

        System.out.println(count);
    }
}
