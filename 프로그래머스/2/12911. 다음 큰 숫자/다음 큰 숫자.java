class Solution {
    public int solution(int n) {
        int answer = 0;
        // 이진수로 바꾸기
        StringBuilder sb = new StringBuilder();
        int index = 0, min = -1;
        while(n!=0){
            if(min == -1 && n%2 == 1) min  = index;
            sb.append(n%2);
            n /= 2;
            index++;
        }
        // 제일작은 1을 오른쪽으로 올리며 1의 개수 세기
        int count = 0;
        // System.out.println(sb);
        // System.out.println(min);
        char[] arr = sb.toString().toCharArray();
        arr[min] = '0';
        for(int i=min+1; i<arr.length; i++){
            if(arr[i] == '0') {
                arr[i] = '1';
                break;
            }
            else {
                count++;
                arr[i] = '0';
            }
        }
        index = 0;
        // 1의 개수 맞추기
        while(count!=0){
            arr[index++] = '1';
            count--;
        }
        // 1을 올렸더니 맨 오른쪽까지 간 경우 처리
        String result = new String(arr);
        if(arr[arr.length - 1] == '0') result += '1';
        // 10진수로 변환
        arr = result.toCharArray();
        index = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '1') answer += index;
            index *= 2;
        }
        return answer;
    }
}