import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        String name;
        int korean, english, math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int kor = Integer.parseInt(input[1]);
            int eng = Integer.parseInt(input[2]);
            int math = Integer.parseInt(input[3]);
            students.add(new Student(name, kor, eng, math));
        }

        students.sort((a, b) -> {
            if (a.korean != b.korean) {
                return b.korean - a.korean; // 국어 내림차순
            } else if (a.english != b.english) {
                return a.english - b.english; // 영어 오름차순
            } else if (a.math != b.math) {
                return b.math - a.math; // 수학 내림차순
            } else {
                return a.name.compareTo(b.name); // 이름 사전순
            }
        });

        for (Student s : students) {
            sb.append(s.name).append('\n');
        }

        System.out.print(sb);
    }
}
