class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // 수거, 배달 포함해서 가장 먼 곳 거리 찾기
        long answer = 0;
        int maxDistance = -1, last1 = deliveries.length, last2 = pickups.length;
        while(maxDistance!=0){
            maxDistance = 0;
            for(int i=last1-1; i>=0; i--){
                if(deliveries[i]!=0) {
                    last1 = i+1;
                    break;
                }
                if(i==0) last1 = 0;
            }
            for(int i=last2-1; i>=0; i--){
                if(pickups[i]!=0) {
                    last2 = i+1;
                    break;
                }
                if(i==0) last2 = 0;
            }
            maxDistance = Math.max(last1, last2);
            // 거꾸로 오면서 배달하고, 수거하기
            int temp1 = cap, temp2 = cap, idx1 = last1-1, idx2 = last2-1;
            // 배달
            while(temp1!=0 && idx1!=-1){
                if(deliveries[idx1]!=0){
                    while(temp1>0 && deliveries[idx1]>0) {
                        temp1--;
                        deliveries[idx1]--;
                    }
                }
                idx1--;
            }
            // 수거
            while(temp2!=0 && idx2!=-1){
                if(pickups[idx2]!=0){
                    while(temp2>0 && pickups[idx2]>0) {
                        temp2--;
                        pickups[idx2]--;
                    }
                }
                idx2--;
            }
            answer += 2 * maxDistance;
        }
        return answer;
    }
}
