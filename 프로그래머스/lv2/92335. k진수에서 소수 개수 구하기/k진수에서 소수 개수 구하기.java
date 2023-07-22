import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String jinsu = change(n, k);
        String[] sosu = jinsu.split("0");
        
        outer:
        for(int i=0; i<sosu.length; i++){
            if(sosu[i].equals("")) continue;
            Long now = Long.parseLong(sosu[i]);
            if(now == 1) continue;
            for(int j=2; j<= Math.sqrt(now); j++){
                if(now % j == 0) continue outer;
            }
            answer++;
        }
        
        return answer;
    }
    
    private String change(int n, int k){
        StringBuilder jinsu = new StringBuilder();
        while(n>0){
            jinsu.append(n % k);
            n /= k;
        }
        return jinsu.reverse().toString();
    }
}