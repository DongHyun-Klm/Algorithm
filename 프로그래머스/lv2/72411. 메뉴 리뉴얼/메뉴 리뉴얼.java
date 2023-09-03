import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        int last = 0;
        Arrays.sort(orders, (a,b) -> a.length() - b.length());
        System.out.println(Arrays.toString(orders));
        for(int i=0; i<course.length; i++){
            map.clear();
            int now = course[i];
            for(int j=last; j<orders.length; j++){
                if(now > orders[j].length()) {
                    last = j;
                    continue;
                }
                sb.setLength(0);
                System.out.println("출발");
                char[] menu = orders[j].toCharArray();
                Arrays.sort(menu);
                combi(menu, now, 0, 0);
            }
            if(map.isEmpty()) continue;
            List<String> keySet = new ArrayList<>(map.keySet());
            keySet.sort((a,b) -> {
                return map.get(b) - map.get(a);
            });
            int max = map.get(keySet.get(0));
            if(max == 1) continue;
            for(int k=0; k<keySet.size(); k++){
                if(max > map.get(keySet.get(k))) break;
                answer.add(keySet.get(k));
            }
            System.out.println(map);
        }
        Collections.sort(answer);
        return answer;
    }
    static private void combi(char[] arr, int now, int d, int start){
       if(d==now){
           String sum = sb.toString();
           System.out.println(sum);
           if(map.containsKey(sum)) map.put(sum, map.get(sum)+1);
           else map.put(sum, 1);
           return;
       }
        for(int i=start; i<arr.length; i++){
            sb.append(arr[i]);
            combi(arr, now, d+1, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}