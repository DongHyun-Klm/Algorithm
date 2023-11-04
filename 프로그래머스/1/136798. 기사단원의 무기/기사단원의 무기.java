class Solution {
    public int solution(int number, int limit, int power) {
        int count = 0;
        int answer = 0;
        for(int i=1; i<=number; i++){
            count = 0;
            for(int j=1; j<=Math.sqrt(i); j++){
                if(i%j==0){
                  count += 2;
                    if(j==Math.sqrt(i)) count--;
                }
                if(count>limit) break;
            }
            if(count>limit) answer += power;
            else answer += count;
        }
        
        
        return answer;
    }
}