import java.util.*;

class Solution {
    static int[] wall;
    static int answer = 0;
    public int solution(int n, int m, int[] section) {
        wall = new int[n+1];
        Arrays.fill(wall, 1);
        for(int i=0; i<section.length; i++){
            wall[section[i]] = 0;
        }
        for(int i=1; i<=n; i++){
            if(wall[i]==0){
                answer++;
                for(int j=0; j<m; j++){
                    if(i+j<=n)wall[i+j] = 1;
                }
            }
        }
        return answer;
    }
}