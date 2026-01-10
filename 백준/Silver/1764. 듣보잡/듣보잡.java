import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        String[] emeeh = new String[n];
        String[] qheh = new String[m];
        
        for (int i=0; i<n; i++) {
            emeeh[i] = br.readLine();
        }
        
        for (int j=0; j<m; j++) {
            qheh[j] = br.readLine();
        }
        
        Arrays.sort(emeeh);
        Arrays.sort(qheh);
        
        int p1 = 0;
        int p2 = 0;
        List<String> lst = new ArrayList<>();
        
        while(p1 < n && p2 < m) {
            
            if (emeeh[p1].equals(qheh[p2])){
                lst.add(emeeh[p1]);
                p1++;
                p2++;
            } else if ( emeeh[p1].compareTo(qheh[p2]) < 0) {
                p1++;
            } else if ( emeeh[p1].compareTo(qheh[p2]) > 0) {
                p2++;
            }
            
        }
        
        System.out.println(lst.size());
        for (String str : lst) {
            System.out.println(str);
        }
    }
    
}