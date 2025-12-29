class Solution {
    public String solution(String pn) {
        
        // 앞의 길이 구하고
        int frontNumber = pn.length() - 4;
        
        String temp = "";
        for (int i=0; i<frontNumber; i++){
            temp += "*";
        }
        
        temp += pn.substring(frontNumber);
        return temp;
    }
}