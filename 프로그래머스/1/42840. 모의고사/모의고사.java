import java.util.*;

class Solution {
    static int[] numbers2 = {1,3,4,5}, numbers3 = {3,1,2,4,5};
    static ArrayList<Integer> al;
    public ArrayList<Integer> solution(int[] answers) {
        al = new ArrayList<>();
        DFS(answers, 0, 0, 0, 0);
        return al;
    }
    private void DFS(int[] answers, int d, int count1, int count2, int count3) {
        if(answers.length == d) {
            int max = Math.max(count1, count2);
            max = Math.max(max, count3);
            if(count1 == max) al.add(1);
            if(count2 == max) al.add(2);
            if(count3 == max) al.add(3);
            return;
        }
        // 1번 수포자 숫자
        int number1 = ((d) % 5) + 1;
        // 2번 수포자 숫자
        int number2 = 0;
        if(d % 2 == 0) number2 = 2;
        else number2 = numbers2[(d % 8) / 2];
        // 3번 수포자 숫자
        int number3 = numbers3[(d % 10) / 2];
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        if(number1 == answers[d]) cnt1++;
        if(number2 == answers[d]) cnt2++;
        if(number3 == answers[d]) cnt3++;
        DFS(answers, d+1, count1 + cnt1, count2 + cnt2, count3 + cnt3);
    }
}