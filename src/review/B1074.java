package review;

import java.util.Scanner;

public class B1074 {

    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();

        DFS(N, R, C);
        System.out.println(result);
    }


    private static void DFS(int N, int R, int C) {
        int boardSize = 1 << N;
        int half = boardSize / 2;

        if (N == 0) return;

        // 1사 분면
        if (R < half && C < half) {
            DFS (N - 1, R, C);
        } else if (R < half && C >= half) {
            result += half * half;
            DFS (N - 1, R, C - half);
        } else if (R >= half && C < half) {
            result += half * half * 2;
            DFS (N - 1, R - half, C);
        } else {
            result += half * half * 3;
            DFS(N - 1, R - half, C - half);
        }
    }
}
