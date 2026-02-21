import java.io.*;
import java.util.*;

public class Main {
    static class Ant {
        char name;
        int dir; // 0: 오른쪽(그룹1), 1: 왼쪽(그룹2)

        Ant(char name, int dir) {
            this.name = name;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        String g1 = br.readLine();
        String g2 = br.readLine();
        int T = Integer.parseInt(br.readLine());

        List<Ant> ants = new ArrayList<>();

        // 그룹1 뒤집어서 추가 (→ 방향 = 0)
        for (int i = n1 - 1; i >= 0; i--) {
            ants.add(new Ant(g1.charAt(i), 0));
        }

        // 그룹2 그대로 추가 (← 방향 = 1)
        for (int i = 0; i < n2; i++) {
            ants.add(new Ant(g2.charAt(i), 1));
        }

        // T초 시뮬레이션
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < ants.size() - 1; i++) {
                Ant a = ants.get(i);
                Ant b = ants.get(i + 1);

                // → 와 ← 가 만나면 swap
                if (a.dir == 0 && b.dir == 1) {
                    ants.set(i, b);
                    ants.set(i + 1, a);
                    i++; // 이미 이동했으므로 건너뜀
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Ant ant : ants) {
            sb.append(ant.name);
        }

        System.out.println(sb);
    }
}