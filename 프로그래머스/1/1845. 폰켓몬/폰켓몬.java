import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            s.add(nums[i]);
        }
        answer = s.size() > nums.length / 2 ? nums.length / 2 : s.size();
        return answer;
    }
}