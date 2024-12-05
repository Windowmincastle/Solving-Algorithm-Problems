import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 등급별 점수 매핑
        Map<String,Double> grade = new HashMap<>();
        
        grade.put("A+", 4.5);
        grade.put("A0",4.0);
        grade.put("B+",3.5);
        grade.put("B0",3.0);
        grade.put("C+",2.5);
        grade.put("C0",2.0);
        grade.put("D+",1.5);
        grade.put("D0",1.0);
        grade.put("F",0.0);

        double totalScore = 0.0;
        double totalCredit = 0.0;
        
        for (int i=0; i<20; i++){

            String[] input = br.readLine().split(" ");
            
            String subject = input[0];
            double credit = Double.parseDouble(input[1]);
            String gr = input[2];

            if (gr.equals("P")) continue;

            totalScore += credit * grade.get(gr); // 학점 x 과목평점의 합
            totalCredit += credit; // 학점의 총합

        }
        
        double gpa = totalScore / totalCredit;
        sb.append(String.format("%.6f",gpa));
        System.out.println(sb);


    }
    
}
