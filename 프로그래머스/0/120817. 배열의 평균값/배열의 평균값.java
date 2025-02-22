class Solution {
    public double solution(int[] numbers) {
        
        double answer = 0;
        
        double total = 0;
        double len = numbers.length;
        for(int i=0; i<numbers.length; i++){
            
            total += numbers[i];
            
        }
        answer = total / len;
        
        return answer;
    }
}