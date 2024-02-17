class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1, right = (long)times[times.length-1] * n;

        while(left < right) {
            long mid = (left + right) / 2;
            long temp = 0;
            for(int i=0; i<times.length; i++) {
                temp += mid / times[i];
            }
            if(temp >= n) {
                answer = mid;
                right = mid;
            }
            else left = mid + 1;
        }
        
        return answer;
    }
}