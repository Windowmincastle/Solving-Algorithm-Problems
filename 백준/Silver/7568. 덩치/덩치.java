import java.io.*;
import java.util.*;

class Person {
    
    int weight;
    int height;
    
    Person(int weight, int height){
        
        this.weight = weight;
        this.height = height;
        
    }
    
}

public class Main {
    
    static void compare(List<Person> list, int N){
       
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<N; i++){
            int num = 0;
            for(int j=0; j<N; j++){
                if (i==j) continue;
                if (list.get(j).weight > list.get(i).weight &&
                    list.get(j).height > list.get(i).height) {

                    num = num + 1;
                }
                
            }
            answer.add(num);
        }
        
        for (int rank : answer){
            System.out.print((rank+1)+" ");
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        
        for (int i=0; i<N; i++){
            
            String[] wh = br.readLine().split(" ");
            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);

            list.add(new Person(w,h)); // 보통은 인스턴스명을 선언하는데 왜 안할까?
        }
        
        compare(list, N);
        
    }
    
}