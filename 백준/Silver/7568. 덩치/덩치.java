import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Person {

    int weight;
    int height;
    int rank;
    
    public Person(int w,int h){
        
        this.weight = w;
        this.height = h;
        this.rank = 1; // 초기 등수는 1 (자기 자신 포함 )
    }

}

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 사람 수
        List<Person> people = new ArrayList<>();

        for (int i = 0; i<N; i++) {
            
            String[] input = br.readLine().split(" "); // input 데이터를 공백을 기준으로 N번 입력 받기
            
            int weight = Integer.parseInt(input[0]); // 배열 0번째는 몸무게
            int height = Integer.parseInt(input[1]); // 배열 1번째는 키
            
            people.add(new Person(weight,height)); // Person List에 add 하기.

        }

        // 등수 계산 size를 쓰는 이유?
        
        for (int i=0; i < people.size(); i++) {
            for (int j=0; j < people.size(); j++){

                if (i != j){ //자기 자신 제외
                    
                    if (people.get(i).weight < people.get(j).weight && people.get(i).height < people.get(j).height){
                        
                        people.get(i).rank++; // 만약에 i보다 j가 키랑 몸무게가 더 크다면 i의 등수를 증가 시킨다.

                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for(Person person : people){
            sb.append(person.rank).append(" ");
        }

        System.out.println(sb.toString().trim());
        
    }
    
}
