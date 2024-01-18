package divide;

import java.util.Scanner;

public class Q1992 {

    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        compress(0,0, N);
    }

    static void compress(int r, int c, int n) {
        if (isSame(r, c, n)) {
            System.out.print(arr[r][c]);
            return;
        }

        System.out.print("(");
        int mid = n / 2;
        compress(r, c, mid);
        compress(r, c + mid, mid);
        compress(r + mid, c, mid);
        compress(r + mid, c +  mid, mid);
        System.out.print(")");
    }

    static boolean isSame(int r, int c, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[r][c] != arr[r + i][c + j]) return false;
            }
        }

        return true;
    }

}
