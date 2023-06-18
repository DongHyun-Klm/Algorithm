import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Character, Integer> M = new HashMap<>();
        int[] cnt = new int[9];
        char[][] arr = new char[N][];
        for(int i=0; i<N; i++) {
            arr[i] = sc.next().toCharArray();
            for(int j=0; j<arr[i].length; j++) {
                if(M.containsKey(arr[i][j])) {
                    // 이미 있다면 더하기
                    M.put(arr[i][j], M.get(arr[i][j])+ (int)Math.pow(10, arr[i].length - j -1));
                }
                // 없다면 저장
                else M.put(arr[i][j], (int)Math.pow(10, arr[i].length - j -1));
            }
        }

        // 우선 순위 높은것부터 나올 수 있도록 pq에 집어 넣기
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(Character c : M.keySet()){
            pq.add(new int[] {c, M.get(c)});
        }

        // 숫자 할당하기
        int number = 9;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            M.put((char) now[0], number--);
        }

        //숫자로 변환해서 답 구하기
        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<arr[i].length; j++) {
                answer += M.get(arr[i][j]) * Math.pow(10, arr[i].length - j -1);
            }
        }

        System.out.println(answer);
    }
}