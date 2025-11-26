import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        char[] alpa = {'a','b','c','d','e','f','g','h','i',
                       'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < alpa.length; i++) {
            map.put(alpa[i], 0);
        }

        for (int i = 0; i < input.length(); i++) {
            char charValue = input.charAt(i);
            map.put(charValue, map.get(charValue) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (Character c : alpa) {
            sb.append(map.get(c)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

}
