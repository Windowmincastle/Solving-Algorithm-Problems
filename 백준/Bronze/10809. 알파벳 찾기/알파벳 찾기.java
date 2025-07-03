import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        char[] ary = {'a','b','c','d','e','f','g','h','i','j',
                      'k','l','m','n','o','p','q','r','s','t',
                      'u','v','w','x','y','z'};

        for (int i = 0; i < ary.length; i++) {

            char target = ary[i];

            // 괄호 수정 완료
            if (input.contains(String.valueOf(target))) {
                sb.append(input.indexOf(target)).append(" ");
            } else {
                sb.append("-1").append(" ");
            }

        }
        System.out.println(sb.toString());
    }
}
