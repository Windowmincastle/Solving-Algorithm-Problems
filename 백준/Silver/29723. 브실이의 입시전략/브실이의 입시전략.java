import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 과목 수, M: 선택할 과목 수, K: 공개된 과목 수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 과목 점수 저장
        Map<String, Integer> subjectScores = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            subjectScores.put(subject, score);
        }

        // 공개된 과목 저장
        Set<String> knownSubjects = new HashSet<>();
        for (int i = 0; i < K; i++) {
            knownSubjects.add(br.readLine());
        }

        // 공개된 과목 점수 합산 & 비공개 과목 점수 리스트 저장
        List<Integer> unknownScores = new ArrayList<>();
        int knownTotalScore = 0;

        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            if (knownSubjects.contains(entry.getKey())) {
                knownTotalScore += entry.getValue();
            } else {
                unknownScores.add(entry.getValue());
            }
        }

        // 비공개 과목 점수 정렬 (오름차순)
        Collections.sort(unknownScores);

        // 최소 점수 계산: 가장 낮은 비공개 과목 점수 M-K개 추가
        int minScore = knownTotalScore;
        for (int i = 0; i < M - K; i++) {
            minScore += unknownScores.get(i);
        }

        // 최대 점수 계산: 가장 높은 비공개 과목 점수 M-K개 추가
        int maxScore = knownTotalScore;
        for (int i = 0; i < M - K; i++) {
            maxScore += unknownScores.get(unknownScores.size() - 1 - i);
        }

        // 결과 출력
        System.out.println(minScore + " " + maxScore);
    }
}
