import java.util.*;

class Solution {
    static Map<String, ArrayList<Integer>> m = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[][] arr = new int[info.length][5];
        for(int i=0; i<info.length; i++){
            String[] divide = info[i].split(" ");
            dfs(0, "", divide);
        }
        for(ArrayList<Integer> L : m.values()){
            Collections.sort(L);
        }
        int index = 0;
        int[] answer = new int[query.length];
        for(String i : query){
            String[] spl = i.split(" and ");
            String[] spl_sc = spl[3].split(" ");
            String s = spl[0] + spl[1] + spl[2] + spl_sc[0];
            int score = Integer.parseInt(spl_sc[1]);
            ArrayList<Integer> now;
            if(m.containsKey(s)) now = m.get(s);
            else {
                answer[index++] = 0;
                continue;
            }
            int start = 0, end = now.size()-1;
            while(start <= end){
                int mid = (start + end) / 2;
                int sc = now.get(mid);
                if(sc >= score){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            answer[index++] = now.size() - start;
        }
        return answer;
    }
    static void dfs(int d, String s, String[] divide){
        if(d == 4){
            if(!m.containsKey(s)){
                ArrayList<Integer> scores = new ArrayList<>();
                scores.add(Integer.parseInt(divide[4]));
                m.put(s, scores);
            }
            else {
                ArrayList<Integer> scores = m.get(s);
                scores.add(Integer.parseInt(divide[4]));
                m.put(s, scores);
            }
            return;
        }
        dfs(d+1, s + divide[d], divide);
        dfs(d+1, s + "-", divide);
    }
}