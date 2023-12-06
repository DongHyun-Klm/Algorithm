import java.util.*;

class Solution {
    static class info {
        int distance;
        int now;
        public info(int distance, int now){
            this.distance = distance;
            this.now = now;
        }

        @Override
        public String toString() {
            return "info{" +
                    "distance=" + distance +
                    ", now=" + now +
                    '}';
        }
    }
    public int solution(int storey) {
        int answer = 0;
        Queue<info> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        q.add(new info(0,storey));
        s.add(storey);
        while(!q.isEmpty()){
            info n = q.poll();
            if(n.now < 0 || n.now > 100000000) continue;
            if(n.now == 0) {
                answer = n.distance;
                break;
            }
            int index = 1;
            boolean flag = true;
            while(n.now >= Math.pow(10, index)) {
                if(n.now % Math.pow(10, index) == 0) index++;
                else break;
            }
            if(!s.contains(n.now + (int)Math.pow(10, index-1))) {
                q.add(new info(n.distance + 1, n.now + (int)Math.pow(10, index-1)));
                s.add(n.now + (int)Math.pow(10, index-1));
            }
            if(!s.contains(n.now - (int)Math.pow(10, index-1))) {
                q.add(new info(n.distance + 1, n.now - (int)Math.pow(10, index-1)));
                s.add(n.now - (int)Math.pow(10, index-1));
            }
        }
        return answer;
    }

}
