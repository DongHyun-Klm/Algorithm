import java.util.*;

class Solution {
    static int max_plus = 0, max_sum = 0;
    static int[] sale = {10, 20, 30, 40}, select;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        select = new int[emoticons.length];
        BT(users, emoticons, 0);
        answer[0] = max_plus;
        answer[1] = max_sum;
        return answer;
    }
    static void BT(int[][] users, int[] emoticons, int d){       
        // 할인율 다 정했다면 최대 목표치와 비교
        if(d==emoticons.length){
            int plus = 0, sum = 0;
            for(int i = 0; i < users.length; i++){
                int temp = 0;
                // 일정 할인 비율 이상이면 구매
                for(int j = 0; j < select.length; j++){
                    if(users[i][0] <= select[j]) temp += emoticons[j] * (100-select[j]) / 100;
                }
                // 일정 구매 금액 이상이면 플러스 구매
                if(temp>= users[i][1]) {
                    plus++;
                }
                // 아니면 그냥 구매
                else{
                    sum += temp;
                }
            }
            // 플러스 서비스 가입자가 맥스 가입자와 같다면 판매액 비교
            if(max_plus == plus){
                if(max_sum < sum) max_sum = sum;
            }
            // 플러스 서비스 가입자가 맥스 가입자보다 많다면 저장
            else if(max_plus < plus){
                max_plus = plus;
                max_sum = sum;
            }
            return;
        }
        // 할인율 완탐
        for(int i=0; i<4; i++){
            select[d] = sale[i];
            BT(users, emoticons, d+1);
            select[d] = 0;
        }
    }
}