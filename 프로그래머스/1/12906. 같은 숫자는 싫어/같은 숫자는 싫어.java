import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> al = new ArrayList();
        int last = -1;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == last) continue;
            last = arr[i];
            al.add(last);
        }
        

        return al;
    }
}