import java.util.*;

class Solution {
    // want 정현이가 원하는 제품을 나타내는 문자열 ["banana","apple"] 등
    // number 정현이가 원하는 제품의 수량        [3,1] 등
    // discount 마트에서 할인하는 제품
    // 가능한 날이 없으면 0을 return 한다.
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        
        Map<String,Integer> orgMap = new HashMap<>();
        
        for (int i=0; i<want.length; i++) {
            
            String key = want[i];
            int value = number[i];

            orgMap.put(key,value);
        }
        
        Map<String,Integer> tempMap = new HashMap<>();
        
        for (int k=0; k<want.length; k++) {
            tempMap.put(want[k],0);
        }
        
        for (int j=0; j<= discount.length - 10; j++) {
            
            String[] sliced = Arrays.copyOfRange(discount, j, j+10);
            
            for (int l=0; l<sliced.length; l++) {
                
                String key = sliced[l];
                tempMap.put(key, tempMap.getOrDefault(key,0)+1);
            }
            
            String[] mapKeys = tempMap.keySet().toArray(new String[0]);
            
            for (String target : mapKeys ) {
                if (!orgMap.containsKey(target)) tempMap.remove(target);
            }
            
            if (orgMap.equals(tempMap)) answer++;
            
            tempMap.clear();
        }
        
        if (answer == 0 ) {
            return 0;
        }
        
        return answer;
    }
}

/*

일정 금액 지불 -> 10일동안 회원자격 부여.
마트에서 '회원'을 대상으로 매일 한 가지 제품을 할인하는 행사를 함.
할인하는 제품은 하루에 하나씩만 구매 가능.
정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 가입을 하려함.

셋째날에 가입하면 열흘간 원하는 제품과 수량이 일치함. 가능한 날 +1
넷째날에 가입하면 열흘간 원하는 제품과 수량이 일치함. 가능한 날 +1
다섯째날 마찬가지 +1

바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개
  1   2   3    4   5   6    7      8      9    10  11   12    13  14 
치킨 사과 사과 바나나 쌀 사과 돼지고기 바나나 돼지고기 쌀  냄비 바나나 사과 바나나

*/