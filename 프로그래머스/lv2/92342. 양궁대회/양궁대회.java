import java.util.*;

class Solution {
    static int max_score = 0;
    static int[] answer;
    public int[] solution(int n, int[] info) {
        int[] result = new int[info.length];
        answer = new int[info.length];
        BT(n, info, result, 0);
        System.out.println(max_score);
        if(max_score == 0) return new int[] {-1};
        return answer;
    }
    static void BT(int n, int[] info, int[] result, int d){
        // 화살 다 쐈다면 또는 끝에 도달
        if(n==0 || d==result.length){
            // 짬처리
            result[10] = n;
            // 점수 차이 계산
            int score = 0, RYAN = 0, APEACH = 0;
            for(int i=0; i<result.length; i++){
                // 둘다 0점이면 pass
                if(info[i]==0&&result[i]==0) continue;
                if(info[i] >= result[i]) APEACH += 10-i;
                else RYAN += 10-i;
            }
            score = RYAN - APEACH;
            // 최대값 비교
            // 틀린부분(4,18 테케)
            //라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 
            //가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
            if(score == max_score){
                for(int i=10; i>=0; i--){
                    if(result[i] > answer[i]) {
                        answer = result.clone();
                        break;
                    }
                    else if(result[i] < answer[i]) break;
                }
            }
            else if(score > max_score){
                max_score = score;
                answer = result.clone();
            }
            return;
        }
        
        
        int ap = info[d];
        // 남은 화살수가 어피치의 i과녁 맞춘 화살수보다 크다면
        if(n>ap){
            // 점수 얻고 다음으로
            int[] temp = new int[result.length];
            temp = result.clone();
            temp[d] = ap+1;
            BT(n - ap - 1, info, temp, d+1);
        }
        // 점수 포기하고 다음으로
        BT(n, info, result, d+1);
    }
}