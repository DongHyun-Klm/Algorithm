import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0, index = 0;
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        while(index < routes.length) {
            answer++;
            int end = routes[index][1];
            for(int i=index+1; i<routes.length; i++) {
                if(routes[i][0] <= end) index = i;
                else break;
            }
            index++;
        }
        return answer;
    }
}