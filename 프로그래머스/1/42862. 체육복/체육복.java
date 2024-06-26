import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int answer = 0;
        //앞번호 or 뒷번호 학생에게만 체육복을 빌려줌
        //최대한 많은 학생이 체육 수업을 들어야함

//        전체 학생의 수 n
//        체육복을 도난당한 학생들의 번호가 담긴 배열 lost
//        여벌의 체육복을 가져온 학생들의 번호 배열 reserve
//        체육 수업을 들을 수 잇는 학생의 최댓값을 반환

//        여벌 체육복을 가져온 학생이 도난을 당햇을 수 있다. 그러면 체육복을 빌려줄 수 없다


        Set<Integer> resSet = new HashSet<>();
        Set<Integer> losSet = new HashSet<>();

//      Set에 담기

        Arrays.sort(reserve);
//        for (int i : reserve) {
//            resSet.add(i);
//        }

        for (int i : lost) {
            losSet.add(i);
        }

        //asdf
        for (int i = 0; i < reserve.length; i++) {
            if (losSet.contains(reserve[i])) {
                losSet.remove(reserve[i]);
                reserve[i] = -1;
            }
        }

        for (int i = 0; i < reserve.length; i++) {
            if (reserve[i] == -1) continue;

            if (losSet.contains(reserve[i] - 1)) {
                losSet.remove(reserve[i] - 1);
            } else if (losSet.contains(reserve[i]+1)) {
                losSet.remove(reserve[i] + 1);
            }
        }
//
//        for (int j : resSet) {

//            if (losSet.contains(j - 1)) {
//                losSet.remove(j - 1);
//            } else if (losSet.contains(j+1)) {
//                losSet.remove(j + 1);
//            }
//        }

        answer = n-losSet.size();
        return answer;
    }
}