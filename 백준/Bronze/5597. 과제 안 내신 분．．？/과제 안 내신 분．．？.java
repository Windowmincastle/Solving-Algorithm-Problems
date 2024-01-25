import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 28명의 학생이 제출한 출석번호를 입력받음
        int[] submittedStudents = new int[28];
        for (int i = 0; i < 28; i++) {
            submittedStudents[i] = scanner.nextInt();
        }

        // 1부터 30까지의 출석번호 중 미제출 학생 찾기
        Arrays.sort(submittedStudents);

        int[] missingStudents = findMissingStudents(submittedStudents);

        // 결과 출력
        System.out.println(missingStudents[0]);
        System.out.println(missingStudents[1]);
    }

    // 미제출 학생 찾는 메서드
    private static int[] findMissingStudents(int[] submittedStudents) {
        int[] missingStudents = new int[2];
        int idx = 0;

        for (int i = 1, j = 0; i <= 30; i++) {
            if (j < 28 && submittedStudents[j] == i) {
                j++;
            } else {
                missingStudents[idx++] = i;
            }
        }

        return missingStudents;
    }
}
