import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력을 받을 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력: 종이의 가로, 세로 길이
        String[] input = br.readLine().split(" ");
        int width = Integer.parseInt(input[0]);  // 가로 길이
        int height = Integer.parseInt(input[1]);  // 세로 길이

        // 두 번째 줄 입력: 잘라야 하는 점선 개수
        int n = Integer.parseInt(br.readLine());

        // 가로선과 세로선을 저장할 리스트 초기화
        List<Integer> horizontalCuts = new ArrayList<>();
        List<Integer> verticalCuts = new ArrayList<>();

        // 초기 종이의 시작과 끝 점선을 추가 (0, 가로/세로 길이)
        horizontalCuts.add(0);
        horizontalCuts.add(height);
        verticalCuts.add(0);
        verticalCuts.add(width);

        // 점선 정보 입력 처리
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int command = Integer.parseInt(line[0]); // 0: 가로, 1: 세로
            int position = Integer.parseInt(line[1]); // 점선 위치

            if (command == 0) {
                horizontalCuts.add(position);  // 가로 점선 위치 저장
            } else {
                verticalCuts.add(position);  // 세로 점선 위치 저장
            }
        }

        // 각 리스트를 정렬 (점선 위치 기준)
        Collections.sort(horizontalCuts);
        Collections.sort(verticalCuts);

        // 최대 가로 길이와 최대 세로 길이를 계산
        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 1; i < verticalCuts.size(); i++) {
            maxWidth = Math.max(maxWidth, verticalCuts.get(i) - verticalCuts.get(i - 1));
        }
        for (int i = 1; i < horizontalCuts.size(); i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts.get(i) - horizontalCuts.get(i - 1));
        }

        // 가장 큰 종이 조각의 넓이 계산
        System.out.println(maxWidth * maxHeight);
    }
}
