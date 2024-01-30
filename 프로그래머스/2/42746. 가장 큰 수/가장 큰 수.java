import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            al.add(numbers[i]);
        }
        
        Collections.sort(al, (a,b) -> {
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);
            
            int n1 = Integer.parseInt(s1 + s2);
            int n2 = Integer.parseInt(s2 + s1);
            return n2 - n1;
        });
        
        for(int i=0; i<numbers.length; i++){
            answer += al.get(i);
        }
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}