class Solution {
    public String solution(String phone_number) {
        String answer = "";
        char[] arr = phone_number.toCharArray();
        for(int i=0; i<phone_number.length(); i++){
            if(i < phone_number.length()-4) answer += '*';
            else answer += arr[i];
        }
        return answer;
    }
}