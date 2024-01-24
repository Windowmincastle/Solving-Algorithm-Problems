class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        String str3 = str1+str2;
        
        int num = Integer.parseInt(str3);
        int num2 = 2 * a * b;
        
        if ( num > num2 ){
            answer = num;
        } else if ( num2 > num ){
            answer = num2;
        } else if (  num == num2){
            answer = num;
        }
        
        return answer;
    }
}