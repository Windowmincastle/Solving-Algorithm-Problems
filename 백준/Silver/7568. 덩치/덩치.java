import java.io.*;
import java.util.*;

class Person {
    
    int w;
    int h;
    int rank;
    
    public Person (int w, int h){
        this.w = w;
        this.h = h;
        this.rank = 1;
    }
}

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<Person> pp = new ArrayList<>();
        
        for (int i=0; i<n; i++){
            
            String[] input = br.readLine().split(" ");
            
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            
            pp.add(new Person(w,h));
        }
        
        for (int i=0; i<pp.size(); i++){
            
            for(int j=0; j<pp.size(); j++){
                
                if(i!=j){
                    if(pp.get(i).w < pp.get(j).w && pp.get(i).h < pp.get(j).h){
                        pp.get(i).rank++;
                    }
                }
            }
        }
     
        StringBuilder sb = new StringBuilder();
        
        for (Person p : pp ){
            
            sb.append(p.rank).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}