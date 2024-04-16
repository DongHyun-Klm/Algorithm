import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    static Map<String, Integer>[] m;
    public int solution(int[] picks, String[] minerals) {
        m = new HashMap[3];
        for(int i=0; i<3; i++) m[i] = new HashMap<>();
        m[0].put("diamond", 1);
        m[0].put("iron", 1);
        m[0].put("stone", 1);
        m[1].put("diamond", 5);
        m[1].put("iron", 1);
        m[1].put("stone", 1);
        m[2].put("diamond", 25);
        m[2].put("iron", 5);
        m[2].put("stone", 1);
        BT(0, 0, 0, picks, minerals);
        return answer;
    }
    private void BT(int d, int pick, int tired, int[] picks, String[] minerals) {
        if(tired >= answer) return;
        if(d == minerals.length) {
            answer = Math.min(tired, answer);
            return;
        }
        if(d % 5 == 0) {
            for(int i=0; i<3; i++) {
                if(picks[i] != 0) break;
                if(i==2) {
                    answer = Math.min(tired, answer);
                    return;
                }
            }
            for(int i=0; i<3; i++) {
                if(picks[i] == 0) continue;
                picks[i]--;
                BT(d+1, i, tired +  m[i].get(minerals[d]), picks, minerals);
                picks[i]++;
            }
        }
        else {
            BT(d+1, pick, tired + m[pick].get(minerals[d]), picks, minerals);
        }
        
    }
}