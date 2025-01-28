import java.util.*;

class Solution {
    public int solution(String s) {

        int answer = 0;
        
        for (int x=0; x<s.length(); x++){
            
            String rotated = s.substring(x) + s.substring(0,x);
            
            if(isValid(rotated)){
                //true를 반환 받으면 if문에 진입해서 answer에 ++를 한다.
                answer++;
                
            }
            
        }
        
        return answer;
    }
    
    public boolean isValid(String s){
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            
            if ( c == '(' || c == '{' || c == '[' ){
                // c가 여는 괄호라면 스택에 push
                stack.push(c);
            } else {
                //c가 닫는 괄호라면 검증을 해야한다.
                
                if (stack.isEmpty()) return false; // 만약 스택이 비어있다면 이미 닫는 괄호가 먼저 나온 경우 이기 때문에 false를 반환해서 카운트 하지 않는다.
                
                char top = stack.pop(); // 여는 괄호와 닫는 괄호가 짝이 맞는지 확인해야 하기 때문에 top에 저장해서 비교한다.
                
                // c가 닫는 괄호이고 top에서 꺼낸것이 올바른 여는 괄호라면 이 if문을 통과하게 되고 answer에 카운트 ++를 하고 top에서 꺼낸것이 올바른 여는 괄호가 아니라면 false를 반환하게 되며 카운트는하지 않는다. 
                if ((c == ')' && top != '(') || 
                    (c == ']' && top != '[') || 
                    (c == '}' && top != '{')) {
                    return false;
                }
                
            }
            
        }
        
        return stack.isEmpty(); // true를 반환하고
    }
}