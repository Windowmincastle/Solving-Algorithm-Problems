import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r1 = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());*/
        
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int s = sc.nextInt();
        System.out.println(2 * s - r1);

    }

}
