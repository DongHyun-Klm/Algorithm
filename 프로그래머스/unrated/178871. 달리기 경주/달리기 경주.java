import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> m = new HashMap<>();
        for(int i=0; i<players.length; i++){
            m.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++){
            int rank = m.get(callings[i]);
            m.put(callings[i], rank-1);
            m.put(players[rank-1], rank);
            swap(players, rank);
        }
        return players;
    }
    private void swap(String players[], int rank){
        String temp = players[rank];
        players[rank] = players[rank-1];
        players[rank-1] = temp;
        return;
    }
}