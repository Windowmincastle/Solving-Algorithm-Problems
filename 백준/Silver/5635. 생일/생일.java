import java.io.*;
import java.util.*;

public class Main{
    
    static class Student {
        
        String name;
        int day;
        int month;
        int year;
        
        public Student(String name,int day,int month,int year){
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            
            students.add(new Student(name,day,month,year));
            
        }
        
        students.sort((s1, s2) -> {
            if (s1.year != s2.year) {
                return s1.year - s2.year; // 연도 기준 정렬
            }
            if (s1.month != s2.month) {
                return s1.month - s2.month; // 월 기준 정렬
            }
            return s1.day - s2.day; // 일 기준 정렬
        });
        
        System.out.println(students.get(n-1).name);
        System.out.println(students.get(0).name);
        
    }
    
}