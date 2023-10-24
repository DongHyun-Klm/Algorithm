class Solution {
    static int answer = 0;
    public int solution(int n) {
        for(int i=1; i<=n; i++){
            BT(i+1, i, n);
        }
        return answer;
    }
    public void BT(int start, int sum, int n) {
        if(sum==n) {
            if(sum == n) answer++;
            return;
        }
        if(sum + start > n) return;
        BT(start+1, sum + start, n);
    }
}