class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0, right = sequence.length, sum = 0;
        for(int i=0, R = 0; i<sequence.length; i++){
            while(sum < k && R < sequence.length){
                sum += sequence[R++];
            }
            if(sum == k){
                int size = R - i - 1;
                if(right - left > size){
                    left = i;
                    right = R - 1;
                }
            }
            sum -= sequence[i];
        }
        
        answer[0] = left; answer[1] = right;
        return answer;
    }
}
