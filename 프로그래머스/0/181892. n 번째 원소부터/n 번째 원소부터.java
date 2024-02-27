class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int size = num_list.length - n;
        int[] answer = new int[size+1];
        
        if ( size == 0){
            int[] tmp = new int[1];
            
            tmp[0] = num_list[num_list.length-1];
            return tmp;
        } else {
            
            for (int i=0; i <=size; i++){
                
                answer[i] = num_list[(n-1)+i];
            }
        } 
        
        return answer;
    }
}