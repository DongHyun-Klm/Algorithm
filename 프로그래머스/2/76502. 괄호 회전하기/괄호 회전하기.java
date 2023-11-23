import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int[] chk = new int[3];
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            Arrays.fill(chk, 0);
            int index = i - 1;
            stk.clear();
            for(int j=0; j<arr.length; j++){
                if(arr.length % 2 == 1) break;
                index++;
                if(index >= arr.length) index -= arr.length;
                char now = arr[index];
                if(now == ')'){
                    if(stk.isEmpty()) break;
                    if(stk.pop() != '(') break;
                }
                else if(now == ']'){
                    if(stk.isEmpty()) break;
                    if(stk.pop() != '[') break;
                }
                else if(now == '}'){
                    if(stk.isEmpty()) break;
                    if(stk.pop() != '{') break;
                }
                else stk.add(now);
                if(j == arr.length - 1) answer++;
            }
        }
        return answer;
    }
}