import java.util.*;

public class Solution {
    static int solution (int n) {

        int sum = 0;
        while (n > 0){
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }
        return sum;
    }
    
    public static int main (int n) {
        return solution(n);
    }
    
}