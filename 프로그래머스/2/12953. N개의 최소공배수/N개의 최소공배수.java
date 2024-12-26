class Solution {
    
    //최대공약수를 구하는 유클리드 알고리즘
    public int getGCD(int a,int b){
        
        while (b != 0) {
            
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        
        return a; 
        
    }
    
    // 최소 공배수 메서드
    public int getLCM(int a,int b){
        return a * b / getGCD(a,b);
    }
    
    public int solution(int[] arr) {
        
        int lcm = arr[0];
        
        for (int i = 1; i < arr.length; i++){
            lcm = getLCM(lcm,arr[i]);
        }
        
        
        return lcm;
    }
}