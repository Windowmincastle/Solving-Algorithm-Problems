import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 필요한 기타줄 개수
        int M = sc.nextInt(); // 브랜드 개수
        
        int minPackage = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;
        
        // 브랜드 별 가격 입력받고 최소값 갱신
        for (int i = 0; i < M; i++) {
            int pack = sc.nextInt();
            int single = sc.nextInt();
            minPackage = Math.min(minPackage, pack);
            minSingle = Math.min(minSingle, single);
        }
        
        // 세 가지 경우를 비교
        int case1 = (N / 6) * minPackage + (N % 6) * minSingle; // 패키지 + 낱개
        int case2 = ((N + 5) / 6) * minPackage; // 패키지로만 (N개 이상)
        int case3 = N * minSingle; // 낱개로만

        int result = Math.min(case1, Math.min(case2, case3));
        System.out.println(result);
    }
}
