import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int min = 21;
        Set<String> s = new HashSet<>();
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j <= phone_book[i].length(); j++){
                String now = phone_book[i].substring(0, j);
                if(s.contains(now)) {
                    answer = false;
                    break;
                }
            }
            s.add(phone_book[i]);
        }
        return answer;
    }
}