import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        al.add(distance);
        for(int i=0; i<rocks.length; i++) {
            al.add(rocks[i]);    
        }
        Collections.sort(al);
        
        int start = 0, end = distance;
        while(start <= end) {
            int mid = (start + end) / 2;
            int count = 0, sum = 0;
            for(int i=1; i<al.size(); i++) {
                sum += al.get(i) - al.get(i-1);
                if(sum >= mid) sum = 0;
                else count++;
            }
            if(count > n) end = mid - 1;
            else {
                answer = mid;
                start = mid + 1;
            }
        }
        return answer;
    }
}