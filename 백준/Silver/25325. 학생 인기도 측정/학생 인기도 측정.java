import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 학생 수
        String[] students = br.readLine().split(" "); // 학생 이름 목록

        // 1. 학생 인기도를 저장하는 TreeMap (이름 기준 정렬)
        Map<String, Integer> popularityMap = new TreeMap<>();
        for (String student : students) {
            popularityMap.put(student, 0);
        }

        // 2. 좋아하는 학생을 읽어 인기도 증가
        for (int i = 0; i < n; i++) {
            String[] likedStudents = br.readLine().split(" ");
            for (String liked : likedStudents) {
                popularityMap.put(liked, popularityMap.get(liked) + 1);
            }
        }

        // 3. Map을 List로 변환하여 정렬 (인기도 내림차순 → 이름 오름차순)
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(popularityMap.entrySet());
        sortedList.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // 인기도 내림차순
            }
            return a.getKey().compareTo(b.getKey()); // 이름 오름차순
        });

        // 4. 결과 출력 (StringBuilder 사용)
        for (Map.Entry<String, Integer> entry : sortedList) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
