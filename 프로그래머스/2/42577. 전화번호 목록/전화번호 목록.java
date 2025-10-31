import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        // 모든 번호를 해시에 넣기
        for (String number : phone_book) {
            map.put(number, 1);
        }

        // 각 번호의 접두사들이 해시에 존재하는지 확인
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String prefix = number.substring(0, i);
                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}
