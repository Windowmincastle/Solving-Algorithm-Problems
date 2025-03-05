import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt(); // 과일 개수
        int L = scanner.nextInt(); // 스네이크버드 초기 길이
        int[] heights = new int[N]; // 과일 높이 배열

        // 과일 높이 입력 받기
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }

        // 과일 높이를 오름차순 정렬
        Arrays.sort(heights);

        // 가장 낮은 과일부터 먹을 수 있는지 확인
        for (int height : heights) {
            // 현재 길이보다 작거나 같은 과일을 먹을 수 있음
            if (L >= height) {
                L++; // 과일을 먹으면 길이가 1 증가
            } else {
                break; // 더 이상 먹을 수 있는 과일이 없으면 종료
            }
        }

        // 최종적으로 늘어난 스네이크버드의 길이 출력
        System.out.println(L);

        scanner.close();
    }
}
