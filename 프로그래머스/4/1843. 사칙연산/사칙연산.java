class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int[][] dp_max = new int[(arr.length + 1) / 2][(arr.length + 1) / 2];
        int[][] dp_min = new int[(arr.length + 1) / 2][(arr.length + 1) / 2];
        int K = dp_max.length;
        for(int i=0; i<K; i++) {
            dp_max[i][i] = Integer.parseInt(arr[i * 2]);
            dp_min[i][i] = Integer.parseInt(arr[i * 2]);
        }
        
        for(int i=1; i<K; i++) {
            for(int j=0; j<K-i; j++) {
                int end = j + i;
                dp_max[j][end] = Integer.MIN_VALUE;
                dp_min[j][end] = Integer.MAX_VALUE;
                for(int k=j; k<end; k++) {
                    if(arr[2*k+1].charAt(0) == '+') {
                        dp_max[j][end] = Math.max(dp_max[j][end], dp_max[j][k] + dp_max[k+1][end]);
                        dp_min[j][end] = Math.min(dp_min[j][end], dp_min[j][k] + dp_min[k+1][end]);
                    }
                    else {
                        dp_max[j][end] = Math.max(dp_max[j][end], dp_max[j][k] - dp_min[k+1][end]);
                        dp_min[j][end] = Math.min(dp_min[j][end], dp_min[j][k] - dp_max[k+1][end]);
                    }
                }
            }
        }
        
        answer = dp_max[0][K-1];
        return answer;
    }
}