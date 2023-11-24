import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stk = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(arr[i] == ')'){
                if(stk.isEmpty() || stk.pop() != '(') {
                    answer = false;
                    break;
                }
            } 
            else stk.add(arr[i]);
        }
        if(!stk.isEmpty()) answer = false;
        return answer;
    }
}