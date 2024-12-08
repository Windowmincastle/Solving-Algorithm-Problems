import java.io.*;

/*
 간단한 문제 풀이 상황에서는 static을 사용해도 무방하지만 확장성과
 유지보수를 고려한 설계가 필요하다면 static 사용을 지양하는 것이 좋다.

 StringBuilder 객체를 전역적으로 활용하여 재귀 호출이 간단하다
 이 문제에서 StringBuilder는 여러 메서드 스택에서 공유가 된다.
 이를 static으로 선언하면 객체를 매번 생성하지 않아도 되며 같은 인스턴스를 재귀적으로 사용할 수 있다.

 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursive(n,0);

        System.out.println(sb);

        
    }

    static void recursive(int n,int depth) {

        String prefix = "____".repeat(depth);

        sb.append(prefix).append("\"재귀함수가 뭔가요?\"\n");
        if (n == 0) {
            sb.append(prefix).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            sb.append(prefix).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            sb.append(prefix).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            sb.append(prefix).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            recursive(n - 1, depth + 1);
        }
        sb.append(prefix).append("라고 답변하였지.\n");
    }

}