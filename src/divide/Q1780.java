package divide;

import java.util.Scanner;

public class Q1780 {

    static int[][] arr;
    static int[] paper;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N][N];
        paper = new int[3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solution(0,0, N);
        for (int i : paper) {
            System.out.println(i);
        }
    }

    static void solution(int R, int C, int L) {

        if (isSame(R, C, L)) {
            int color = arr[R][C] + 1;
            paper[color]++;
            return;
        }

        int next = L / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution(R + i * next, C + j * next, next);
            }
        }

    }

    static boolean isSame(int R, int C, int L) {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (arr[R][C] != arr[i + R][j + C]) return false;
            }
        }
        return true;
    }
}
