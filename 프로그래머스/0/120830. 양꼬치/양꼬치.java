class Solution {
    public int solution(int n, int k) {
        // n 인분 = 12000원 , 음료수k = 2천원
        
        int food = 12000;
        int water = 2000;
        int service = n / 10;
        
        int foodSum = n * food;
        int waterSum = k * water;
        int serviceSum = service * water; 
        
        
        int answer = (foodSum + waterSum) - serviceSum;
        return answer;
    }
}