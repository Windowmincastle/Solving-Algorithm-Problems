import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 초기 현금
        int cashInit = Integer.parseInt(br.readLine().trim());
        
        // 14일간 주가
        int[] price = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        
        // --- BNP 전략 시뮬레이션 ---
        int bnpCash = cashInit;
        int bnpStock = 0;
        for (int i = 0; i < 14; i++) {
            // 살 수 있는 최대 주식 수
            int buy = bnpCash / price[i];
            bnpStock += buy;
            bnpCash   -= buy * price[i];
        }
        int bnpAsset = bnpCash + bnpStock * price[13];
        
        // --- TIMING 전략 시뮬레이션 ---
        int tCash = cashInit;
        int tStock = 0;
        for (int i = 3; i < 14; i++) {
            // 3일 연속 상승이면 전량 매도
            if (price[i-3] < price[i-2] && price[i-2] < price[i-1] && price[i-1] < price[i]) {
                // 매도
                tCash  += tStock * price[i];
                tStock  = 0;
            }
            // 3일 연속 하락이면 전량 매수
            else if (price[i-3] > price[i-2] && price[i-2] > price[i-1] && price[i-1] > price[i]) {
                // 매수
                int buy = tCash / price[i];
                tStock += buy;
                tCash  -= buy * price[i];
            }
            // 그 외의 날은 아무것도 하지 않음
        }
        int tAsset = tCash + tStock * price[13];
        
        // 결과 비교 후 출력
        if (bnpAsset > tAsset) {
            System.out.println("BNP");
        } else if (bnpAsset < tAsset) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
