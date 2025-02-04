import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        // lost에서 lostSet으로 체육복을 잃어버린 학생들을 저장.
        for (int l : lost){
            
            lostSet.add(l);
            
        }
        
        // 체육복을 빌려줄 수 있는 사람일 경우라도 도난을 당했다면 자신의 체육복을 입어야하기 때문에 lostSet에서 contains로 해당 경우를 remove하기
        for (int r : reserve) {
            
            if (lostSet.contains(r)) {
                
                lostSet.remove(r);
                
            } else {
                //그런 경우가 아니라면 빌려줄 수 있기 때문에 add
                reserveSet.add(r);
                
            }
            
        }
        
        // 빌려주기
        
        int ableToAttend = n - lostSet.size();
        List<Integer> lostList = new ArrayList<>(lostSet);
        
        for (int l : lostList){
            
            if(reserveSet.contains(l-1)){
                
                reserveSet.remove(l-1);
                ableToAttend++;
                
            } else if (reserveSet.contains(l + 1)){
                
                reserveSet.remove(l+1);
                ableToAttend++;
            }
            
        }

        
        
        return ableToAttend;
    }
}