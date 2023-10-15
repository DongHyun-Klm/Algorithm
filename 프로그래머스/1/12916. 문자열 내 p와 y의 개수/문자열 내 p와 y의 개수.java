class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[2];
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='p' || arr[i]=='P'){
                count[0]++;
            }
            else if(arr[i]=='y' || arr[i]=='Y'){
                count[1]++;
            }
        }
        boolean answer = count[0] == count[1];
        return answer;
    }
}