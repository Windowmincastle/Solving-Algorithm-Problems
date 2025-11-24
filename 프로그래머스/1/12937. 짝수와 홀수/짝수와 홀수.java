class Solution {
    
    public String OddorEven(int num) {
        
        String result = "";
        
        if ( num == 0) {
            result = "Even";
            
            return result;
        }
        
        if ( num % 2 == 0){
            result = "Even";
            
        } else {
            result = "Odd";
        }
        
        
        return result;
    }
    
    public String solution(int num) {
        return OddorEven(num);
    }
}