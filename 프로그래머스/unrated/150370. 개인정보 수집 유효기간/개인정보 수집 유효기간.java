import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Character, Integer> m = new HashMap<>();
        // 오늘 날짜
        int todayInt = getDate(today);
        System.out.println(todayInt);
        // 약관 종류별 유효기간 담기
        for(int i=0; i<terms.length; i++){
            String[] now = terms[i].split(" ");
            m.put(now[0].charAt(0), Integer.parseInt(now[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            if (getDate(privacy[0]) + (m.get(privacy[1].charAt(0)) * 28) <= todayInt) {
                answer.add(i + 1);
            }
        }
       return answer.stream().mapToInt(integer -> integer).toArray();
    }
    
    static private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}