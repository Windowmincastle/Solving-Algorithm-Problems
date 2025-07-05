import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        // 저장된 사이트 주소의 수 N
        int n = Integer.parseInt(input[0]);
        // 비밀번호를 찾으려는 사이트 주소의 수 M
        int m = Integer.parseInt(input[1]);
        
        // N개의 줄에 걸쳐 각 줄에 사이트 주소와 비밀번호가 공백으로 주어짐.
        Map<String,String> saves = new HashMap<>();
        
        for (int i=0; i<n; i++){
            
            String[] siteAndpassword = br.readLine().split(" ");
            String site = siteAndpassword[0];
            String password = siteAndpassword[1];
            
            saves.put(site,password);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int j=0; j<m; j++){
            
            String target = br.readLine();
            sb.append(saves.get(target)).append("\n");
            
        }
        
        System.out.println(sb.toString());
        
    }
    
}