import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stk = new Stack<>();
        char[] arr = number.toCharArray();
        for(int i=0; i<arr.length; i++){
            int now = arr[i] - '0';
            while(k!=0 && !stk.isEmpty() && stk.peek()<now) {
                stk.pop();
                k--;
            }
            stk.add(now);
        }
        while(k>0){
            k--;
            stk.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        String answer = sb.reverse().toString();
        return answer;
    }
}