import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        System.out.println(countCroatian(input));
    }

    // 입력 문자열에서 크로아티아 알파벳 개수를 반환
    static int countCroatian(String s) {
        int n = s.length();
        int i = 0;
        int count = 0;

        while (i < n) {
            int matched = matchLength(s, i); // 현재 위치에서 매칭되는 크로아티아 알파벳 길이(0,2,3)
            if (matched > 0) {
                i += matched;
            } else {
                i++;
            }
            count++;
        }
        return count;
    }

    // 현재 인덱스 i에서 시작하는 크로아티아 알파벳의 길이를 반환
    // 없으면 0, "dz="이면 3, 그 외 2글자 치환이면 2
    static int matchLength(String s, int i) {
        int n = s.length();

        // 먼저 길이가 3인 "dz=" 체크 (우선순위 중요)
        if (i + 2 < n && s.charAt(i) == 'd' && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
            return 3;
        }

        // 길이 2인 치환들
        if (i + 1 < n) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);

            // 목록: c=, c-, d-, lj, nj, s=, z=
            if (a == 'c' && (b == '=' || b == '-')) return 2;
            if (a == 'd' && b == '-') return 2;
            if (a == 'l' && b == 'j') return 2;
            if (a == 'n' && b == 'j') return 2;
            if (a == 's' && b == '=') return 2;
            if (a == 'z' && b == '=') return 2;
        }

        return 0; // 매칭 없음 -> 일반 문자 1개
    }
}
