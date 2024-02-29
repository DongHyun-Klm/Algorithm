import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        for(int i=0; i<jobs.length; i++) {
            pq.add(jobs[i]);
        }
        PriorityQueue<int[]> temp = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        });
        while(!pq.isEmpty()) {
            if(time < pq.peek()[0]) time = pq.peek()[0];
            while(!pq.isEmpty() && pq.peek()[0] <= time) {
                temp.add(pq.poll());
            }
            int[] now = temp.poll();
            time += now[1];
            answer += time - now[0];
            while(!temp.isEmpty()) pq.add(temp.poll());
        }
        answer /= jobs.length;
        return answer;
    }
}