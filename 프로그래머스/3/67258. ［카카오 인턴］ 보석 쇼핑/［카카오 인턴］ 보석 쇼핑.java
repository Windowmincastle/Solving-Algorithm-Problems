class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> uniqueSet = new HashSet<>(Arrays.asList(gems));
        String[] uniqueAry = uniqueSet.toArray(new String[]); 
        System.out.println(uniqueAry);
        int[] answer = {};
        return answer;
    }
}