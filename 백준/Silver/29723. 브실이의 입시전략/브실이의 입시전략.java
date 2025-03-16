import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine(); // 개행 처리

        // 과목 점수 저장
        Map<String, Integer> subjectScores = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            String subject = input[0];
            int score = Integer.parseInt(input[1]);
            subjectScores.put(subject, score);
        }

        // 공개된 과목 저장
        Set<String> knownSubjects = new HashSet<>();
        for (int i = 0; i < K; i++) {
            knownSubjects.add(sc.nextLine());
        }

        // 공개된 과목 점수 합산
        List<Integer> knownScores = new ArrayList<>();
        List<Integer> unknownScores = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            if (knownSubjects.contains(entry.getKey())) {
                knownScores.add(entry.getValue());
            } else {
                unknownScores.add(entry.getValue());
            }
        }

        // 비공개 과목 점수 정렬
        Collections.sort(unknownScores);

        // 최소 점수 계산: 가장 낮은 비공개 과목 점수 M-K개 추가
        int minScore = knownScores.stream().mapToInt(Integer::intValue).sum();
        for (int i = 0; i < M - K; i++) {
            minScore += unknownScores.get(i);
        }

        // 최대 점수 계산: 가장 높은 비공개 과목 점수 M-K개 추가
        int maxScore = knownScores.stream().mapToInt(Integer::intValue).sum();
        for (int i = 0; i < M - K; i++) {
            maxScore += unknownScores.get(unknownScores.size() - 1 - i);
        }

        // 결과 출력
        System.out.println(minScore + " " + maxScore);
    }
}
