import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    // 1) 알파벳 A(0)~Z(25) 획수표
    private static final int[] STROKES = {
        3,2,1,2,3,3,2,3,3,2,   // A~J
        2,1,2,2,1,2,2,2,1,2,   // K~T
        1,1,1,2,2,1            // U~Z
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nameA = br.readLine().trim();
        String nameB = br.readLine().trim();
        br.close();

        // 2) 초기 숫자 배열 만들기
        int[] initial = buildInitialArray(nameA, nameB);

        // 3) 궁합 계산: 길이가 2가 될 때까지 반복
        int[] result = computeCompatibility(initial);

        // 4) 두 자리 결과 출력 (앞자리 0 포함)
        System.out.printf("%d%d\n", result[0], result[1]);
    }

    /**
     * A[0], B[0], A[1], B[1], ... 순서로 글자 교차하고
     * 각 글자를 획수로 변환한 길이 2N 배열 반환
     */
    private static int[] buildInitialArray(String a, String b) {
        int n = a.length();
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[2*i]     = strokeCount(a.charAt(i));
            arr[2*i + 1] = strokeCount(b.charAt(i));
        }
        return arr;
    }

    /** 단일 대문자 알파벳의 획수를 반환 */
    private static int strokeCount(char ch) {
        return STROKES[ch - 'A'];
    }

    /**
     * 주어진 배열에서 인접 합의 일의 자리로 새 배열을 만들고,
     * 길이가 2가 될 때까지 재귀(또는 반복)로 처리하여 최종 길이 2 배열 반환
     */
    private static int[] computeCompatibility(int[] arr) {
        int len = arr.length;
        if (len == 2) {
            return arr;
        }
        // 다음 단계 배열 생성
        int[] next = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            next[i] = (arr[i] + arr[i + 1]) % 10;
        }
        // 재귀 호출로 반복
        return computeCompatibility(next);
    }
}