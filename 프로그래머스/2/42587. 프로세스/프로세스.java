import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int rank = 1;
        int[] count = new int[10], order = new int[priorities.length];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            count[priorities[i]]++;
            q.add(new int[] {i, priorities[i]});
        }
        while(!q.isEmpty()) {
            int priority = -1;
            for(int i=9; i>=0; i--) {
                if(count[i]!=0) {
                    priority = i;
                    break;
                }
            }
            int[] now = q.poll();
            if(now[1] == priority) {
                order[now[0]] = rank++;
                count[priority]--;
            }
            else q.add(now);
        }
        int answer = order[location]; 
        return answer;
    }
}