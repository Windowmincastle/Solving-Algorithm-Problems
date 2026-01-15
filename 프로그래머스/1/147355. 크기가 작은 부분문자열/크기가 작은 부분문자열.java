import java.util.*;

class Solution {
    
    public static List<Long> subStr = new ArrayList<>(); 
    
    public void createSubStr(String t, String p) {
        
        long tLen = t.length();
        long pLen = p.length();
                              
        for (int i=0; i <= tLen-pLen; i++) {
            String temp = "";
            
            for (int j=i; j < i+pLen; j++) {
                temp += t.charAt(j);
            }
            subStr.add(Long.valueOf(temp));
        }
    }
    
    public int compareValue(long pValue) {
        
        int cnt = 0;
        
        for (long num : subStr) {
            if (num <= pValue ) cnt++;
        }
        
        return cnt;
    }
    
    public static int solution (String t, String p) {
        Solution sol = new Solution();
        
        sol.createSubStr(t,p);
        int answer = sol.compareValue(Long.valueOf(p));
        
        return answer;

    }
}