import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        
        for (int i=0; i<M; i++) {
            
            String[] input = br.readLine().split(" ");
            String com = input[0];
            
            if(input.length == 2){
                
                int x = Integer.parseInt(input[1]);
                
                switch (com){
                    case "add":
                        set.add(x);
                        break;
                    case "remove":
                        set.remove(x);
                        break;
                    case "check":
                        sb.append(set.contains(x) ? "1\n" : "0\n");
                        break;
                    case "toggle":
                        if (set.contains(x)){
                            set.remove(x);
                        } else {
                            set.add(x);
                        }
                        break;
                }
                
            } else if (input.length == 1) {
                
                switch (com) {
                    case "all":
                        set.clear();
                        for (int j=1; j<=20; j++){
                            set.add(j);
                        }
                        break;
                    case "empty":
                        set.clear();
                        break;
                }
            }
            
        }
        System.out.print(sb);        
    }
}