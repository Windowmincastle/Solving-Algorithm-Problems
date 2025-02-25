class Solution {
    public int[] solution(long n) {
        int[] answer = sol(n);
        
        return answer;
    }
    
    public static int[] sol(long n){
        
        String str = String.valueOf(n);
        StringBuilder reverse = new StringBuilder(str).reverse();
        
        int[] result = new int[reverse.length()];
        
        for (int i=0; i<reverse.length(); i++){
            result[i] = reverse.charAt(i) - '0'; 
        }
        
        return result;
        
        
    }
}