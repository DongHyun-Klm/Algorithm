import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 입차 시간 담을 배열
        int[] come  = new int[10000];
        Arrays.fill(come, -1);
        // 누적 주차 시간 담을 배열
        int[] park = new int[10000];
        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            int carNum = Integer.parseInt(record[1]);
            // IN
            if(record[2].equals("IN")){
                come[carNum] += getTime(record[0]) + 1;
            }
            // OUT
            else{
                park[carNum] += getTime(record[0]) - come[carNum];
                come[carNum] = -1;
            }
        }
        // 차 안뺀애들 체크
        for(int i=0; i<10000; i++){
            if(come[i]!=-1){
                park[i] += (23*60 + 59) - come[i];
            }
        }
        
        // 요금 계산
        for(int i=0; i<10000; i++){
            if(park[i]!=0){
                // 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
                if(park[i]<=fees[0]) answer.add(fees[1]);
                else{
                    int fee = fees[1] + ((park[i] - fees[0]) / fees[2]) * fees[3];
                    // 올림 처리 
                    if(((park[i] - fees[0]) % fees[2]) != 0) fee += fees[3];
                    answer.add(fee);
                }
            }
        }
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
    private int getTime(String now){
        String[] time = now.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return hour * 60 + minute;
    }
}