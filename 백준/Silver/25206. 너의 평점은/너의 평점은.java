import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 등급 → 평점 매핑
        Map<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);

        double totalScore = 0.0;   // 학점 × 평점 합
        double totalCredit = 0.0;  // 학점 총합

        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            
            double credit = Double.parseDouble(input[1]);
            String grade = input[2];

            // P는 계산 제외
            if (grade.equals("P")) continue;

            totalCredit += credit;
            totalScore += credit * gradeMap.get(grade);
        }

        double gpa = totalScore / totalCredit;
        System.out.printf("%.6f\n", gpa);
    }
}
