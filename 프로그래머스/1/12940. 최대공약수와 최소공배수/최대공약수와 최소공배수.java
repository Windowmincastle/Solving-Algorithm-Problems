class Solution {

    static int number = 1000000;
 
    // 최대공약수 - 두 수가 공통으로 가지는 약수 중 가장 큰 수
    static int getGCD (int n, int m) {
        // 최대공약수
        int gcd = 1;
        int limit = Math.min(n,m);
        
        for (int i=1; i <= limit; i++) {
            
            if (n % i == 0 && m % i == 0 ) {
                gcd = i;
            }
        }

        return gcd;
    }
    
    static int getLCM (int n, int m) {
        // 1. 최소공배수는 큰 수부터 시작하면 된다.
        // 2. n과 m 둘 다로 나누어떨어지는
        // 3. 가장 처음 나오는 수
        int max = Math.max(n,m);
        
        for (int i = max; ; i++) {
            
            if (i % n == 0 && i % m == 0) {
                return i;
            }
        }

    }
    
    public int[] solution(int n, int m) {
        
        return new int[] {getGCD(n,m),getLCM(n,m)};

    }
    
}