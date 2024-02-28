import java.util.*;

class Solution {
    static int min = 987654321;
    public int solution(String name) {
        int answer = 0;
        char[] name2 = name.toCharArray();
        int[] arr = new int[name2.length];
        boolean[] chk = new boolean[arr.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Math.min(name2[i] - 'A', 'Z' - name2[i] + 1);
            answer += arr[i];
            if(arr[i] != 0) chk[i] = true;
        }
        if(arr.length == 1) return answer;
        
        DFS(0, 0, chk);
        answer += min;
        return answer;
    }
    private void DFS(int point, int sum, boolean[] chk) {
        // System.out.println(Arrays.toString(chk) + point + " " + sum);
        chk[point] = false;
        int point1 = point;
        int point2 = point;
        for(int i=1; i<=chk.length/2; i++) {
            point1--;
            if(point1 < 0) point1 += chk.length;
            if(chk[point1]) {
                boolean[] copy1 = chk.clone();
                DFS(point1, sum + i, copy1);
                break;
            }
        }
        
        for(int i=1; i<=chk.length/2; i++) {
            point2++;
            if(point2 >= chk.length) point2 -= chk.length;
            if(chk[point2]) {
                boolean[] copy2 = chk.clone();
                DFS(point2, sum + i, copy2);
                break;
            }
        }
        for(int i=0; i<chk.length; i++) if(chk[i]) return;
        min = Math.min(sum, min);
    }
}