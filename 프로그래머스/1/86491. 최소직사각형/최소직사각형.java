class Solution {
    public int solution(int[][] sizes) {
        int max_w = 0, max_h = 0;
        
        for(int i=0; i<sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            max_w = Math.max(w, max_w);
            max_h = Math.max(h, max_h);
        }
        
        int answer = max_w * max_h;
        
        return answer;
    }
}