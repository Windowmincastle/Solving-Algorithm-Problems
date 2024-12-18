class Solution {
    public int[] solution(String s) {
        
        int convertCnt = 0;
        int removeCnt = 0;
        
        while (!s.equals("1")) {
            
            convertCnt++;
            
            int orgLen = s.length();
            s = s.replace("0","");
            int newLen = s.length();
            
            removeCnt += (orgLen - newLen);
            
            s = Integer.toBinaryString(newLen);
            
        }
        
        return new int[] {convertCnt, removeCnt};
    }
}