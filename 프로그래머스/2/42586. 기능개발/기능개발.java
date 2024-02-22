import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> al = new ArrayList();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            q.add((int) Math.ceil((100-progresses[i]) / (double)speeds[i]));
        }
        
        int max = 0, count = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            if(now <= max) {
                count++;
            }
            else {
                max = now;
                if(count != 0) al.add(count);
                count = 1;
            }
        }
        al.add(count);
        return al;
    }
}