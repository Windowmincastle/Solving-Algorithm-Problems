import java.io.*;
import java.util.*;

public class Main {

    // 공백/줄바꿈 상관없이 안전하게 정수 읽기
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }
        int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return -1; // 입력 종료 대비
                st = new StringTokenizer(line);
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int nA = fs.nextInt();
        int nB = fs.nextInt();

        // A를 TreeSet에 담아 오름차순 유지
        TreeSet<Integer> setA = new TreeSet<>();
        for (int i = 0; i < nA; i++) {
            setA.add(fs.nextInt());
        }

        // B는 포함 여부 확인만 하면 되므로 HashSet
        int cap = (int)(nB / 0.75f) + 1; // 해시셋 용량 여유
        HashSet<Integer> setB = new HashSet<>(cap);
        for (int i = 0; i < nB; i++) {
            setB.add(fs.nextInt());
        }

        // 차집합: A \ B
        setA.removeAll(setB);

        StringBuilder sb = new StringBuilder();
        sb.append(setA.size()).append('\n');
        if (!setA.isEmpty()) {
            for (int x : setA) sb.append(x).append(' ');
            sb.setLength(sb.length() - 1); // 마지막 공백 제거
        }

        System.out.print(sb.toString());
    }
}
