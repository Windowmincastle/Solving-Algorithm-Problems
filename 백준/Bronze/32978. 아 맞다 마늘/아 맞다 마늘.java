import java.io.*;
import java.util.*;

public class Main {
    
    static List<String> createList (String[] foodList, List<String> list){
        
        for ( String n : foodList){

            list.add(n);
        }
        
        return list;
    }
    
    static String searchForgetFood(List<String> orglist, List<String> forgetList){
        
        String answer = "";
        
        for (String temp : forgetList){
            orglist.remove(temp);
        }
        return orglist.get(0);
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] orgfoodList = br.readLine().split(" ");
        
        List<String> orgList = new ArrayList<>();
        
        orgList = createList(orgfoodList,orgList);
        
        String[] forgetfoodList = br.readLine().split(" ");
        List<String> forgetList = new ArrayList<>();
        forgetList = createList(forgetfoodList,forgetList);
            
        // 판별 메서드 호출
        String answer = searchForgetFood(orgList,forgetList);
        
        System.out.println(answer);
    }
    
}