class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        boolean flag = true;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ' ') {
                flag = true;
                continue;
            }
            // 앞에 공백인데 뒤에 소문자
            if(flag) {
                if(arr[i]>=97&&arr[i]<=122) arr[i] -= 32;
                flag = false;
            }
            // 앞에 공백 아닌데 대문자
            else {
                if(arr[i]>=65&&arr[i]<=90) arr[i] += 32;
            }
        }
        String answer = new String(arr);
        return answer;
    }
}
