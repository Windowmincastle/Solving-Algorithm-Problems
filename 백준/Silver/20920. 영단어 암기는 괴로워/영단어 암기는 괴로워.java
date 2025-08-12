import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue; // M보다 짧으면 패스
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, (a, b) -> {
            int freqCompare = map.get(b) - map.get(a);
            if (freqCompare != 0) return freqCompare; // 빈도 높은 순
            int lengthCompare = b.length() - a.length();
            if (lengthCompare != 0) return lengthCompare; // 길이 긴 순
            return a.compareTo(b); // 사전 순
        });

        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w).append("\n");
        }

        System.out.print(sb.toString());
    }
}
