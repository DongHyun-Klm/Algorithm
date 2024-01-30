import java.util.*;

class Solution {
    static class info {
        String genre;
        int play, index;
        info (String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
        public String toString(){
            return genre + " " + play + " " + index;
        }
    }
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>(); 
        Map<String, Integer> m = new HashMap<>();
        info[] arr = new info[genres.length];
        for(int i=0; i<genres.length; i++) {
            m.put(genres[i], m.getOrDefault(genres[i], 0) + plays[i]);
            arr[i] = new info(genres[i], plays[i], i);
        }
        // info 배열을 문제 조건대로 정렬
        Arrays.sort(arr, (a,b) -> {
            if(m.get(a.genre) == m.get(b.genre)){
                if(a.play == b.play) {
                    return a.index - b.index;
                }
                return b.play - a.play;
            }
            return m.get(b.genre) - m.get(a.genre);
        });
        
        // 첫곡 담고 시작
        int index = 1, cnt = 1;
        answer.add(arr[0].index);
        while(index < genres.length) {
            // 장르바뀌면 cnt 초기화
            if(!arr[index].genre.equals(arr[index-1].genre)) cnt = 0;
            // 이미 같은장르 2곡 담았다면 pass
            if(cnt == 2) {
                index++;
                continue;
            }
            answer.add(arr[index].index);
            cnt++;
            index++;
        }
        return answer;
    }
}