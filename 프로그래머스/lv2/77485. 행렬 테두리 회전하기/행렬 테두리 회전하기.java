import java.util.*;

class Solution {
    static int[][] arr;
    public ArrayList<Integer> solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1; i <= rows; i++){
            for(int j=columns * (i-1) + 1; j <= columns * i; j++){
                arr[i-1][(j-1)%columns] = j;
            }
        }
        for(int i=0; i<queries.length; i++){
            answer.add(turn(queries[i][0], queries[i][1], queries[i][2], queries[i][3]));
        }
        return answer;
    }
    private int turn(int r1, int c1, int r2, int c2){
        int last = arr[r1-1][c1-1], min = last;
        int temp;
        // 윗줄 가로
        for(int i=c1; i<c2; i++){
            temp = arr[r1-1][i];
            arr[r1-1][i] = last;
            last = temp;
            min = Math.min(min, last);
        }
        // 오른쪽 세로
        for(int i=r1; i<r2; i++){
            temp = arr[i][c2-1];
            arr[i][c2-1] = last;
            last = temp;
            min = Math.min(min, last);
        }
        // 아래 가로
        for(int i=c2-2; i>=c1-1; i--){
            temp = arr[r2-1][i];
            arr[r2-1][i] = last;
            last = temp;
            min = Math.min(min, last);
        }
        // 왼쪽 세로
        for(int i=r2-2; i>=r1-1; i--){
            temp = arr[i][c1-1];
            arr[i][c1-1] = last;
            last = temp;
            min = Math.min(min, last);
        }
        return min;
    }
}