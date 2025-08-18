class Solution {
    
    static String isEvenAndOdd(int number) {

        String even = "Even";
        String odd = "Odd";
        
        if ( number%2 == 0 ) {
            return even;
        } else {
            return odd;
        }
    }
    
    public String solution(int num) {
        return isEvenAndOdd(num);
    }
}