import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> bookSales = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            bookSales.put(book, bookSales.getOrDefault(book, 0) + 1);
        }

        String bestSeller = "";
        int maxSales = 0;

        for (Map.Entry<String, Integer> entry : bookSales.entrySet()) {
            String book = entry.getKey();
            int sales = entry.getValue();

            if (sales > maxSales || (sales == maxSales && book.compareTo(bestSeller) < 0)) {
                maxSales = sales;
                bestSeller = book;
            }
        }

        sb.append(bestSeller);
        System.out.println(sb);
    }
}
