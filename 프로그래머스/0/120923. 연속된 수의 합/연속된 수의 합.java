class Solution {
    public int[] solution(int num, int total) {
        
        int[] answer = new int[num]; // 정답 반환하는 배열.
        int start = (total/num) - ((num-1)/2);
        
        for (int i=0; i<num; i++){
            answer[i] = start;
            start++;
        }
        
        return answer;
    
    }
}