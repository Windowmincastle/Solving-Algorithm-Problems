import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물이 새는 위치의 수
        int L = Integer.parseInt(st.nextToken()); // 테이프 길이
        
        int[] leaks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leaks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leaks); // 위치를 오름차순 정렬

        int count = 0;
        double range = 0; // 현재 테이프가 막을 수 있는 끝 위치

        for (int i = 0; i < N; i++) {
            if (leaks[i] > range) { // 현재 위치가 기존 테이프 범위를 벗어나면
                count++;
                range = leaks[i] - 0.5 + L; // 새 테이프 설치
            }
        }

        System.out.println(count);
    }
}
