import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  T =sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(); // N = 상자개수
            int[] arr = new int[N];
            // 배열(상자 무게 리스트) 받기
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            // 아이디어 -> 제일 큰 박스 기준으로 무게 50을 채우기 위해 필요한 박스를 아래서부터 가져오자
            
            // 오름차순 정렬
            Arrays.sort(arr);
            // top -> 제일 큰 박스부터 index내려오자 
            // down -> 제일 작은박스부터 index올라가자
            // cnt -> 상자 옮기는 횟수
            int top = N-1, down = 0, cnt=0;
            // top - down < 0이 된다면 모든 박스를 확인했다는 것
            while (top-down>-1) {
                // n은 arr[top]을 기준으로 무게 50을 채우기 위해 필요한 상자의 개수 
                // 제일 위 상자의 무개가 50이라면 n= 1, 25라면 n=2, 17이라면 n=3, ... ,1이라면 n=50
                int n = 49/arr[top] + 1;
                // 남은 상자의 개수가 필요한 개수 n보다 작다면 중단
                if(top-down+1<n)break;
                else {
					// 제일 큰 상자가 50이상이라면 n==1 이때는 top만 감소
					// 필요한 상자 개수가 1이상이라면 top에서 1개 감소하고 나머지는 작은박스 사용(down증가)
					cnt++;
					top--;
					for (int j = 0; j < n - 1; j++) {
						down++;
					}
				}
            }
            // cnt는 상자 옮긴 횟수
            System.out.printf("#%d %d\n",i+1,cnt);
        }
    }
}