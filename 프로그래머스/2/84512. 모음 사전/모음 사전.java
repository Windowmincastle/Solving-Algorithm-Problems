class Solution {
    public int solution(String word) {
        // 모음 순서
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        // 각 자리 가중치
        int[] weight = {781, 156, 31, 6, 1};
        
        int answer = 0;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = 0;
            
            // 현재 문자가 몇 번째 모음인지 찾기
            for (int j = 0; j < vowels.length; j++) {
                if (vowels[j] == c) {
                    index = j;
                    break;
                }
            }
            
            // 해당 자리의 가중치 * index + 1(자기 자신 포함)
            answer += index * weight[i] + 1;
        }
        
        return answer;
    }
}
