import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int classNumber = 1; // Class 번호는 1부터 시작
        StringTokenizer st;

        for (int i = 0; i < k; i++) {
            System.out.println("Class " + classNumber);
            classNumber++;

            st = new StringTokenizer(br.readLine());
            int student_cnt = Integer.parseInt(st.nextToken());

            int max = 0;
            int min = Integer.MAX_VALUE; // 매우 큰 값으로 초기화
            int gap = 0;
            int[] ary = new int[student_cnt];

            for (int j = 0; j < student_cnt; j++) {
                ary[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ary);

            max = ary[ary.length - 1];
            min = ary[0];

            for (int m = 0; m < ary.length - 1; m++) { // 반복 변수 변경
                if (ary[m + 1] - ary[m] > gap) {
                    gap = ary[m + 1] - ary[m];
                }
            }

            System.out.println("Max " + max + ", Min " + min + ", Largest gap " + gap);
        }
    }
}
