import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        char[] arr = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        stk.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(!stk.isEmpty() && arr[i] == stk.peek()) stk.pop(); 
            else stk.add(arr[i]);
        }
        if(stk.isEmpty()) answer = 1;
        return answer;
    }
}