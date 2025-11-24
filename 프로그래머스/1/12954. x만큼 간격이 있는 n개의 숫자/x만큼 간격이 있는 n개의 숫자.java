class Solution {
    public long[] solution(int x, int n) {
        // x = -4 , n = 2
        long[] answer = new long[n]; // {0,0,0,0,0}
        for (int i=0; i<n; i++){
            
            long temp = i+1;
            // {2,0,0,0,0}
            answer[i] = x*temp;
        
        }
        
        return answer;
    }
}

/*

정수 2랑
정수 5를 입력 받아서, 2부터 시작해서 2씩 증가하는 숫자를 5개 지니는 리스트를 리턴해야한다.

*/