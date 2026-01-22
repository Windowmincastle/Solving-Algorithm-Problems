import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Student> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            list.add(new Student(name,k,e,m));
        }
        
        // Comparable 기준을 쓰고싶다면 Comparator.naturalOrder()를 인자로 전달
        list.sort(Comparator.naturalOrder());
        
        StringBuilder sb = new StringBuilder();
        for (Student stu : list) {
            sb.append(stu.name).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}

class Student implements Comparable<Student> {
    
    String name;
    int K;
    int E;
    int M;
    
    Student(String name, int K, int E, int M) {
        this.name = name;
        this.K = K;
        this.E = E;
        this.M = M;
    }
    
    @Override
    public int compareTo(Student o2) {
        
        // 국어 점수 비교, 내림차순
        if (this.K != o2.K) {
            return o2.K - this.K;
        }
        
        // 국어 점수가 같다면 영어 점수를 오름차순으로 비교한다.
        if (this.E != o2.E) {
            return this.E - o2.E;   
        }
        // 국어 점수도 같고, 영어점수도 같으면 수학 점수 내림차순
        if (this.M != o2.M) return o2.M - this.M;
        
        // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 
        return this.name.compareTo(o2.name);
    }
}