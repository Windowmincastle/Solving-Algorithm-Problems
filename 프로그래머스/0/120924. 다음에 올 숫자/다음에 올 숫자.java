class Solution {
    public int solution(int[] common) {

        int answer;
        int length = common.length;

        if ((common[1]-common[0]) == (common[2]-common[1]))
        {
            int a = common[length-1] - common[length-2];
            answer = a + common[length-1];
        } 
        else 
        {
            answer = common[length-1] * (common[1]/common[0]);
        }

        return answer;
    }
}