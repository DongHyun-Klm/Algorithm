import java.util.*;

public class Main {
    static int N;
    static int[] slk;
    static int[][] arr_ori;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        slk = new int[5];
        arr_ori = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr_ori[i][j] = sc.nextInt();
            }
        }
        BT(0);
        System.out.println(answer);
    }

    private static void BT(int d) {
        if(d==5){
            int[][] copy = new int[N][N];
            for (int i = 0; i < N; i++) {
                copy[i] = arr_ori[i].clone();
            }
            for (int i = 0; i < 5; i++) {
                switch (slk[i]) {
                    case 0 :
                        moveRight(copy);
                        break;
                    case 1 :
                        moveDown(copy);
                        break;
                    case 2 :
                        moveLeft(copy);
                        break;
                    case 3 :
                        moveUp(copy);
                        break;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer = Math.max(answer, copy[i][j]);
                }
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            slk[d] = i;
            BT(d+1);
        }
    }


    // 네방향 함수 하나로 하고 싶은데 너무 변수가 많을듯한
    // 왼쪽 이동
    static void moveLeft(int[][] arr){
        for (int i = 0; i < N; i++) {
            int index = 0;
            while (index < N-1){
                if(arr[i][index] != 0) {
                    int index_temp = index + 1;
                    while (index_temp != N){
                        if(arr[i][index_temp] == 0) index_temp++;
                        else if(arr[i][index] == arr[i][index_temp]) {
                            arr[i][index] <<= 1;
                            arr[i][index_temp] = 0;
                            break;
                        }
                        else {
                            arr[i][index+1] = arr[i][index_temp];
                            if(index+1 != index_temp) arr[i][index_temp] = 0;
                            break;
                        }
                    }
                }
                index++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if(arr[i][j] != 0) {
                    q.add(arr[i][j]);
                    arr[i][j] = 0;
                }
            }
            index = 0;
            while(!q.isEmpty()) {
                arr[i][index++] = q.poll();
            }
        }
    }
    // 오른쪽 이동
    static void moveRight(int[][] arr){
        for (int i = 0; i < N; i++) {
            int index = N-1;
            while (index > 0){
                if(arr[i][index] != 0) {
                    int index_temp = index - 1;
                    while (index_temp >= 0){
                        if(arr[i][index_temp] == 0) index_temp--;
                        else if(arr[i][index] == arr[i][index_temp]) {
                            arr[i][index] <<= 1;
                            arr[i][index_temp] = 0;
                            break;
                        }
                        else {
                            arr[i][index-1] = arr[i][index_temp];
                            if(index-1 != index_temp) arr[i][index_temp] = 0;
                            break;
                        }
                    }
                }
                index--;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int j = N-1; j >= 0; j--) {
                if(arr[i][j] != 0) {
                    q.add(arr[i][j]);
                    arr[i][j] = 0;
                }
            }
            index = N-1;
            while(!q.isEmpty()) {
                arr[i][index--] = q.poll();
            }
        }
    }
    // 위쪽 이동
    static void moveUp(int[][] arr){
        for (int i = 0; i < N; i++) {
            int index = 0;
            while (index < N-1){
                if(arr[index][i] != 0) {
                    int index_temp = index + 1;
                    while (index_temp != N){
                        if(arr[index_temp][i] == 0) index_temp++;
                        else if(arr[index][i] == arr[index_temp][i]) {
                            arr[index][i] <<= 1;
                            arr[index_temp][i] = 0;
                            break;
                        }
                        else {
                            arr[index+1][i] = arr[index_temp][i];
                            if(index+1 != index_temp) arr[index_temp][i] = 0;
                            break;
                        }
                    }
                }
                index++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if(arr[j][i] != 0) {
                    q.add(arr[j][i]);
                    arr[j][i] = 0;
                }
            }
            index = 0;
            while(!q.isEmpty()) {
                arr[index++][i] = q.poll();
            }
        }
    }
    // 아래쪽 이동
    static void moveDown(int[][] arr){
        for (int i = 0; i < N; i++) {
            int index = N-1;
            while (index > 0){
                if(arr[index][i] != 0) {
                    int index_temp = index - 1;
                    while (index_temp >= 0){
                        if(arr[index_temp][i] == 0) index_temp--;
                        else if(arr[index][i] == arr[index_temp][i]) {
                            arr[index][i] <<= 1;
                            arr[index_temp][i] = 0;
                            break;
                        }
                        else {
                            arr[index-1][i] = arr[index_temp][i];
                            if(index-1 != index_temp) arr[index_temp][i] = 0;
                            break;
                        }
                    }
                }
                index--;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int j = N-1; j >= 0; j--) {
                if(arr[j][i] != 0) {
                    q.add(arr[j][i]);
                    arr[j][i] = 0;
                }
            }
            index = N-1;
            while(!q.isEmpty()) {
                arr[index--][i] = q.poll();
            }
        }
    }
}