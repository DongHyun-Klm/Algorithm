class Solution {
    public int solution(int n) {
        int[] fibo = new int[100001];
        fibo[1] = 1;
        for(int i=2; i<fibo.length; i++){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }
        int answer = fibo[n];
        return answer;
    }
}