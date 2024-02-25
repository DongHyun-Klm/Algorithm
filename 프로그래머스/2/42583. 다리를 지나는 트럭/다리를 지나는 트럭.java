import java.util.*;

class Solution {
    static class info {
        int weight, time;
        public info (int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<info> bridge = new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++) {
            q.add(truck_weights[i]);
        }
        while(!q.isEmpty() || !bridge.isEmpty()) {
            int total = 0;
            int size = bridge.size();
            for(int i=0; i<size; i++) { 
                info now = bridge.poll();
                if(now.time < bridge_length) {
                    total += now.weight;
                    bridge.add(new info(now.weight, now.time + 1));
                }
            }
            if(!q.isEmpty() && total + q.peek() <= weight) bridge.add(new info(q.poll(), 1));
            answer++;
        }
        return answer;
    }
}