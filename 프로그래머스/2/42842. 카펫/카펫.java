class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow, width = 3, height = total / width;
        while(height>2){
            if(total%width!=0) {
                width++;
                height = total / width;
                continue;
            }
            if(2 * width + 2 * height - 4 == brown){
                answer = new int[] {height, width};
                break;
            }
            width++;
            height = total / width;
        }
        return answer;
    }
}