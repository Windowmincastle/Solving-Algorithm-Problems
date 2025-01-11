import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Nation implements Comparable<Nation> {
        private int name;
        private int gold;
        private int silver;
        private int bronze;
        private int rank;

        public Nation(int name, int gold, int silver, int bronze) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rank = 1; // 초기 순위는 1로 설정
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze; // 동메달 비교
                } else {
                    return o.silver - this.silver; // 은메달 비교
                }
            } else {
                return o.gold - this.gold; // 금메달 비교
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 국가 수
        int k = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가 번호

        List<Nation> medalList = new ArrayList<>();

        // 국가 정보 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int name = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            medalList.add(new Nation(name, gold, silver, bronze));
        }

        // 메달 순위로 정렬
        Collections.sort(medalList);

        // 순위 계산
        for (int i = 1; i < n; i++) {
            Nation current = medalList.get(i);
            Nation previous = medalList.get(i - 1);

            if (current.gold == previous.gold && 
                current.silver == previous.silver && 
                current.bronze == previous.bronze) {
                current.rank = previous.rank; // 이전 국가와 메달 수가 같으면 같은 순위
            } else {
                current.rank = i + 1; // 그렇지 않으면 현재 인덱스 + 1
            }
        }

        // 특정 국가의 순위 출력
        for (Nation nation : medalList) {
            if (nation.name == k) {
                System.out.println(nation.rank);
                break;
            }
        }
    }
}
