import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 0; tc < 10; tc++) {
            int N = sc.nextInt();
            char[] arr = new char[N+1];
            // 트리를 입력받자
            for (int i = 0; i < N; i++) {
                // char 알파벳만 받고 뒤에 입력은 버림
                arr[sc.nextInt()] = sc.nextLine().charAt(1);
            }
            System.out.printf("#%d ",tc+1);
            traverse(1,N, arr);
            System.out.println();
        }
    }
    private static void traverse(int i, int N, char[] arr) {
        if (i <= N) {
            // 중위 순회
 
            // L: 왼쪽 트리로 탐색을 이어나감
            traverse(i * 2, N, arr);
 
            // V: 자기 자신을 방문처리
            if (arr[i] != '\u0000')
                System.out.print(arr[i]);
 
            // R: 오른쪽으로 탐색을 이어나감
            traverse(i * 2 + 1, N, arr);
 
        }
         
    }
}