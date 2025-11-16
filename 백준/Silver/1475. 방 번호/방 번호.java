import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();

        char[] chars = roomNumber.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();

        // 0~9 초기화(안 해도 되지만 깔끔함)
        for (int i = 0; i <= 9; i++) {
            map.put(i, 0);
        }

        // 1. 각 숫자의 빈도수 카운트
        for (char c : chars) {
            int num = c - '0';
            map.put(num, map.get(num) + 1);
        }

        // 2. 6과 9를 합쳐서 세트 수 계산
        int six = map.get(6);
        int nine = map.get(9);

        // (6의 개수 + 9의 개수)를 반으로 나누는데, 홀수면 올림해야 한다.
        int sixNineSet = (six + nine + 1) / 2; // 올림(ceil)을 integer 계산으로 표현한 방식

        // 6과 9의 개수를 "대체된 개수"로 변경
        map.put(6, sixNineSet);
        map.put(9, sixNineSet);

        // 3. 가장 많이 필요한 숫자가 전체 세트 수를 결정
        int answer = 0;

        for (int i = 0; i <= 9; i++) {
            answer = Math.max(answer, map.get(i));
        }

        System.out.println(answer);
    }
}
