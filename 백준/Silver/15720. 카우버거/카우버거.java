import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int B = sc.nextInt(); // 버거 개수
        int C = sc.nextInt(); // 사이드 개수
        int D = sc.nextInt(); // 음료 개수

        Integer[] burgers = new Integer[B];
        Integer[] sides = new Integer[C];
        Integer[] drinks = new Integer[D];

        // 버거 가격 입력
        for (int i = 0; i < B; i++) {
            burgers[i] = sc.nextInt();
        }

        // 사이드 가격 입력
        for (int i = 0; i < C; i++) {
            sides[i] = sc.nextInt();
        }

        // 음료 가격 입력
        for (int i = 0; i < D; i++) {
            drinks[i] = sc.nextInt();
        }

        // 총 원가 계산
        int total = 0;
        for (int i = 0; i < B; i++) total += burgers[i];
        for (int i = 0; i < C; i++) total += sides[i];
        for (int i = 0; i < D; i++) total += drinks[i];

        // 각 배열 내림차순 정렬
        Arrays.sort(burgers, Collections.reverseOrder());
        Arrays.sort(sides, Collections.reverseOrder());
        Arrays.sort(drinks, Collections.reverseOrder());

        int setCount = Math.min(B, Math.min(C, D)); // 세트로 만들 수 있는 최대 수
        int discountTotal = 0;

        // 세트 가격 계산 (할인 적용)
        for (int i = 0; i < setCount; i++) {
            int setPrice = burgers[i] + sides[i] + drinks[i];
            discountTotal += (int) (setPrice * 0.9);
        }

        // 세트로 못 묶인 나머지 항목 가격 더하기
        for (int i = setCount; i < B; i++) discountTotal += burgers[i];
        for (int i = setCount; i < C; i++) discountTotal += sides[i];
        for (int i = setCount; i < D; i++) discountTotal += drinks[i];

        // 결과 출력
        System.out.println(total);
        System.out.println(discountTotal);
    }
}
