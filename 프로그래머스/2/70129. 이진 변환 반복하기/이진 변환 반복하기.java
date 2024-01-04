class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        while(s.length() != 1){
            int count = 0;
            answer[0]++;
            sb.setLength(0);
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == '0') answer[1]++;
                else count++;
            }
            while(count != 0){
                sb.append(count%2);
                count /= 2;
            }
            s = sb.toString();
        }
        return answer;
    }
}