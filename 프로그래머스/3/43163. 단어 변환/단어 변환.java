import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Set<String> s = new HashSet<>();
        for(String t : words) s.add(t);
        Queue<String> q = new LinkedList<>();
        boolean flag = false;
        q.add(begin);
        o:
        while(!q.isEmpty()) {
            int size = q.size();
            answer++;
            while(size --> 0) {
                char[] now = q.poll().toCharArray();
                for(int i=0; i<now.length; i++) {
                    for(int k=0; k<26; k++) {
                        StringBuilder temp = new StringBuilder();
                        for(int j=0; j<now.length; j++) {
                            if(j==i) {
                                temp.append((char)(k+97));
                            }
                            else temp.append(now[j]);
                        }
                        if(s.contains(temp.toString())) {
                            if(temp.toString().equals(target)) {
                                flag = true;
                                break o;
                            }
                            q.add(temp.toString());
                            s.remove(temp.toString());
                        }
                    }
                }
            }
        }
        if(!flag) answer = 0;
        return answer;
    }
}