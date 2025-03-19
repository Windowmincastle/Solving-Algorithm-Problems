import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> permutedList;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        permutedList = new ArrayList<>();
        backtrack(0);
        System.out.println(maxResult);
    }

    static void backtrack(int depth) {
        if (depth == N) {
            maxResult = Math.max(maxResult, calculateSum());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutedList.add(arr[i]);
                backtrack(depth + 1);
                permutedList.remove(permutedList.size() - 1);
                visited[i] = false;
            }
        }
    }

    static int calculateSum() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(permutedList.get(i) - permutedList.get(i + 1));
        }
        return sum;
    }
}
