import java.util.*;

class Solution {
    static class DualPriorityQueue {
        PriorityQueue<Integer> minQ = new PriorityQueue<>((a,b) -> a-b);
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b)-> b-a);
        
        public void add(int a) {
            minQ.add(a);
            maxQ.add(a);
        }
        
        public void removeMax() {
            if(maxQ.isEmpty()) return;
            int a = maxQ.poll();
            minQ.remove(a);
        }
        
        public void removeMin() {
            if(minQ.isEmpty()) return;
            int a = minQ.poll();
            maxQ.remove(a);
        }
        
        public int getMax() {
            if(maxQ.isEmpty()) return 0;
            return maxQ.peek();
        }
        
        public int getMin() {
            if(minQ.isEmpty()) return 0;
            return minQ.peek();
        }
    }
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        DualPriorityQueue dq = new DualPriorityQueue();
        for(String s : operations) {
            String[] srr = s.split(" ");
            if(srr[0].charAt(0) == 'I') {
                dq.add(Integer.parseInt(srr[1]));
            }
            else {
                if(srr[1].charAt(0) == '1') dq.removeMax();
                else dq.removeMin();
            }
        }
        answer[0] = dq.getMax();
        answer[1] = dq.getMin();
        return answer;
    }
}