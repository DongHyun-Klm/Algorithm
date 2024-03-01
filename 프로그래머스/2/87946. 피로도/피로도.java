import java.util.*;

class Solution {
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        Arrays.sort(dungeons, (a,b) -> b[0] - a[0]);
        boolean[] visit = new boolean[dungeons.length];
        BT(dungeons, visit, k, 0);
        return answer;
    }
    private void BT(int[][] dungeons, boolean[] visit, int k, int cnt) {
        answer = Math.max(answer, cnt);
        for(int i=0; i<dungeons.length; i++) {
            if(visit[i]) continue;
            if(dungeons[i][0] > k) continue;
            boolean[] copy = visit.clone();
            copy[i] = true;
            BT(dungeons, copy, k - dungeons[i][1], cnt + 1);
        }
    }
}