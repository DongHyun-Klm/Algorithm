import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int point1 = 0, point2 = people.length - 1;
        while(point1 <= point2){
            int now = people[point2--];
            if(now + people[point1] <= limit) point1++;
            answer++;
        }
        return answer;
    }
}