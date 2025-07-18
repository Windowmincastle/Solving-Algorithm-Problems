import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    // 신호등 정보를 담는 DTO
    static class Signal {
        int position;
        int red;
        int green;
        Signal(int position, int red, int green) {
            this.position = position;
            this.red = red;
            this.green = green;
        }
    }

    public static void main(String[] args) throws IOException {
        // 1) 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<Signal> signals = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            signals.add(new Signal(d, r, g));
        }

        // 2) 시뮬레이션 수행
        int resultTime = simulate(signals, L);

        // 3) 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(resultTime);
        System.out.println(sb.toString());
    }

    /**
     * 신호등 리스트와 도로 길이를 받아,
     * 출발(0)에서 도착(L)까지 걸리는 총 시간을 계산합니다.
     */
    private static int simulate(List<Signal> signals, int roadLength) {
        int currentPos = 0;
        int time = 0;

        for (Signal sig : signals) {
            // 2-1) 신호등까지 이동
            time += sig.position - currentPos;
            currentPos = sig.position;

            // 2-2) 도착 시점에 빨간불인지 확인 후 대기
            int cycle = sig.red + sig.green;
            int mod = time % cycle;
            if (mod < sig.red) {
                time += (sig.red - mod);
            }
        }

        // 2-3) 마지막 지점까지 이동
        time += (roadLength - currentPos);
        return time;
    }
}
