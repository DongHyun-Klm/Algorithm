class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // 수거, 배달 포함해서 가장 먼 곳 거리 찾기
        long answer = 0;
        // 시간초과때문에 만든 last1, last2
        int last1 = deliveries.length - 1, last2 = pickups.length - 1;
        while(last1 !=-1 || last2 != -1){
            for(int i=last1; i>=0; i--){
                if(deliveries[i]!=0) {
                    last1 = i;
                    break;
                }
                if(i==0) last1 = -1;
            }
            for(int i=last2; i>=0; i--){
                if(pickups[i]!=0) {
                    last2 = i;
                    break;
                }
                if(i==0) last2 = -1;
            }
            int maxDis = Math.max(last1, last2) + 1;
            // 거꾸로 오면서 배달하고, 수거하기
            int temp1 = cap, temp2 = cap;
            // 배달
            while(temp1!=0 && last1!=-1){
                if(deliveries[last1]!=0){
                    while(temp1>0 && deliveries[last1]>0) {
                        temp1--;
                        deliveries[last1]--;
                    }
                }
                if(temp1!=0) last1--;
            }
            // 수거
            while(temp2!=0 && last2!=-1){
                if(pickups[last2]!=0){
                    while(temp2>0 && pickups[last2]>0) {
                        temp2--;
                        pickups[last2]--;
                    }
                }
                if(temp2!=0) last2--;
            }
            answer += 2 * maxDis;
        }
        return answer;
    }
}
