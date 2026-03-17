import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        /*
        인접한 두 방 사이의 거리는 같은 거리라고 가정한다. 예를들어 101호와 102호의 거리는 1이고 102호와 105호의 거리는 3이다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());


//        핵심 아이디어 = 층 = N % H , 호수 = (N / H ) + 1  [나머지가 0이 아닐떄]
//        나머지가 0일떄 -> 호수만 구하는 방법이 다름 (N / H ) + 1
//        (층이 먼저 다 차고) → 다음 호수로 이동
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<tc; i++) {

            String[] inputs = br.readLine().split(" ");

            int h = Integer.parseInt(inputs[0]); // 층수
            int w = Integer.parseInt(inputs[1]); // 방수
            int n = Integer.parseInt(inputs[2]); // 몇 번 째 손님인지?

            // 방은 YXX 나 YYXX 형태 , Y나 YY는 층 수 , XX 방번호
            // 그러면, 일의자리면 -> String -> 0 -> Integer + 호수
            int floor = n % h;
            if ( floor == 0 ) floor = h;

            int room;
            if ( n % h == 0) {
                room = n / h;
            } else { // 0이 아닐때
                room = ( n / h ) + 1;
            }

            String strFloor = String.valueOf(floor);
            String strRoom = String.valueOf(room);
            // 조건문 순서 주의, room만 항상 2자리로 만들면되는데,
            if( strRoom.length() == 1) {
                strRoom = "0" + strRoom;
            }

            String lastStr = strFloor + strRoom;
            sb.append(lastStr).append("\n");
        }

        System.out.println(sb.toString());
    }
}
