import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

public class Main {
    // 참가자 정보를 담을 클래스
    static class Participant {
        int country;
        int studentNo;
        int score;
        Participant(int country, int studentNo, int score) {
            this.country = country;
            this.studentNo = studentNo;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1) 입력: 참가자 수 N
        int N = Integer.parseInt(br.readLine().trim());

        // 2) 참가자 리스트에 정보 저장
        List<Participant> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int studentNo = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            list.add(new Participant(country, studentNo, score));
        }

        // 3) 점수 내림차순 정렬
        Collections.sort(list, new Comparator<Participant>() {
            @Override
            public int compare(Participant p1, Participant p2) {
                // 내림차순: p2.score - p1.score (음수/양수로 비교 가능)
                return Integer.compare(p2.score, p1.score);
            }
        });

        // 4) 메달 선정: 한 나라당 최대 2개
        Map<Integer, Integer> medalCountByCountry = new HashMap<>();
        List<Participant> winners = new ArrayList<>();

        for (Participant p : list) {
            if (winners.size() >= 3) break;  // 이미 3명 선정 완료
            int country = p.country;
            int cnt = medalCountByCountry.getOrDefault(country, 0);
            if (cnt < 2) {
                // 이 참가자는 메달 수여 대상
                winners.add(p);
                medalCountByCountry.put(country, cnt + 1);
            }
            // cnt >= 2면 건너뛰고 다음 참가자 확인
        }

        // 5) 결과 출력: 금, 은, 동 순서대로 winners 리스트에 담긴 순서가 이미 점수 내림차순이므로 그대로 출력
        StringBuilder sb = new StringBuilder();
        for (Participant p : winners) {
            sb.append(p.country).append(' ').append(p.studentNo).append('\n');
        }
        System.out.print(sb.toString());
    }
}
