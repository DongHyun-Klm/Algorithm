import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dir = new HashMap<>();
        char c = 'A';
        for(int i=1;i<=26;i++){
            dir.put(c+"", i);
            c++;
        }
        int index = 0, end_dir = 27;
        ArrayList<Integer> list = new ArrayList<>();
         while(index<msg.length()){
            int cut = 1;
            while(index + cut <= msg.length()){
            	if(index + cut == msg.length()) {
            		list.add(dir.get(msg.substring(index, index + cut)));
            		index += cut;
            		break;
            	}
            	else if(!dir.containsKey(msg.substring(index, index + cut+1))){
                    list.add(dir.get(msg.substring(index, index + cut)));
                    dir.put(msg.substring(index, index + cut+1), end_dir++);
                    index += cut;
                    break;
                }
                else cut++;
            }
        }
        System.out.println(list);
        int[] answer = new int[list.size()];
        int size = 0;
        for(int n : list) {
        	answer[size++] = n;
        }
        return answer;
    }
}