import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static int solution(int[] nums ){

        int answer = 0;

        Set<Integer> mySet = new HashSet<>();

        for (int n : nums) {
            mySet.add(n);
        }

        System.out.println(mySet);

        if (mySet.size() > nums.length / 2) {
            answer = nums.length/2;
        } else {
            answer = mySet.size();
        }

        return answer;
    }
}