class Solution {
    public int solution(int[] numbers) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int num : numbers) {
            sb.append(num);
        }
        
        int answer = 0;
        String[] str = {"0","1","2","3","4","5","6","7","8","9"};
        String strNumber = sb.toString();
        
        for (String s : str ){
            if (!strNumber.contains(s)){
                answer += Integer.parseInt(s);
            }
        }
        
        return answer;
    }
}