import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] numbers = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            numbers[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(numbers);
        answer = numbers[0] + " " + numbers[numbers.length-1];
        return answer;
    }
}