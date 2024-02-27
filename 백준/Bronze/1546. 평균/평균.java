import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double maxValue = 0; // 수정: double로 선언
        
        // 성적 입력 받기.
        double[] grade = new double[n];
        double[] newGrade = new double[n];
        
        for (int i=0; i<n; i++){
            grade[i] = input.nextInt();
        }
        
        input.close(); // Scanner 객체 닫기
        
        maxValue = grade[0];
        for (int i=1; i<n; i++){
            if (grade[i] > maxValue){
                maxValue = grade[i];
            }
        }
        
        // 원점수 / maxValue * 100
        for (int i=0; i<n; i++){
            newGrade[i] = grade[i] / maxValue * 100;
        }
        
        double avg = 0;
        
        for (int i=0; i<n; i++){
            avg += newGrade[i];
        }
        
        double answer = avg / n;
        
        // 수정: 새로운 평균을 출력
        System.out.println(answer);
    }
}
