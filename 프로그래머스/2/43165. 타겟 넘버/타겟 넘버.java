class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return answer;
    }
    private void DFS(int[] numbers, int target, int d, int sum) {
        if(numbers.length == d) {
            if(sum == target) answer++;
            return;
        }
        DFS(numbers, target, d+1, sum + numbers[d]);
        DFS(numbers, target, d+1, sum - numbers[d]);
    }
}