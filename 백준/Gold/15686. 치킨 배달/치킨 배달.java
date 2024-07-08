import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] city;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickenShops = new ArrayList<>();
    static int minChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (city[i][j] == 2) {
                    chickenShops.add(new int[]{i, j});
                }
            }
        }
        
        combination(new int[M], 0, 0);
        System.out.println(minChickenDistance);
    }

    // combination method to choose M chicken shops out of all available chicken shops
    public static void combination(int[] comb, int start, int depth) {
        if (depth == M) {
            minChickenDistance = Math.min(minChickenDistance, getChickenDistance(comb));
            return;
        }

        for (int i = start; i < chickenShops.size(); i++) {
            comb[depth] = i;
            combination(comb, i + 1, depth + 1);
        }
    }

    // calculate chicken distance for a particular combination of chicken shops
    public static int getChickenDistance(int[] comb) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int hx = house[0], hy = house[1];
            int minDistance = Integer.MAX_VALUE;

            for (int i : comb) {
                int[] chicken = chickenShops.get(i);
                int cx = chicken[0], cy = chicken[1];
                int distance = Math.abs(hx - cx) + Math.abs(hy - cy);
                minDistance = Math.min(minDistance, distance);
            }

            totalDistance += minDistance;
        }

        return totalDistance;
    }
}
