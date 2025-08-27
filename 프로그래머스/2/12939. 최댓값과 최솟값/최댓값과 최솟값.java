class Solution {
    
    static int getMaxIntegerValue(String[] input){
        
        int answer = Integer.parseInt(input[0]);
        
        for (int i=1; i<input.length; i++){
            
            int temp = Integer.parseInt(input[i]);
            if ( temp > answer ){
                answer = temp;
            }
        }
        
        return answer;
    }
    
    static int getMinIntegerValue(String[] input){
        
        int answer = Integer.parseInt(input[0]);
        
        for (int i=1; i<input.length; i++){
            
            int temp = Integer.parseInt(input[i]);
            
            if ( temp < answer){
                answer = temp;
            }
        }
        
        return answer;
    }
    
    public String solution(String s) {
        
        String[] input = s.split(" ");
        
        String temp = " ";
        String maxValue = String.valueOf(getMaxIntegerValue(input));
        String minValue = String.valueOf(getMinIntegerValue(input));
        String answer = minValue+temp+maxValue;
        return answer;
    }
}