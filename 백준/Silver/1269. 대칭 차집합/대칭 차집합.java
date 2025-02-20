import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        // A 집합 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        // B 집합 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        // 대칭 차집합 크기 계산
        int result = symmetricDifferenceSize(A, B);

        System.out.println(result);
    }

    public static int symmetricDifferenceSize(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);  // 합집합 생성

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // 교집합 생성

        result.removeAll(intersection); // 합집합에서 교집합 제거하여 대칭 차집합 생성

        return result.size();
    }
}
