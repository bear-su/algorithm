package old.recursion;

import java.util.Scanner;

public class Q17136 {

    static int[][] board = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int nextR = 0, nextC = 0, answer = 26;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        solution(0, 0);

        if (answer == 26) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void solution(int cr, int cnt) {
        if (answer <= cnt) return;
        findNext(cr);

        // 색종이로 덮어야 하는 구간 없음
        if (nextR == -1 && nextC == -1) {
            answer = cnt;
            return;
        }

        // 색종이로 덮어야 하는 구간이 존재
        int r = nextR;
        int c = nextC;

        for (int size = 1; size <= 5; size++) {
            // 색종이가 없으면 다음 사이즈로
            if (paper[size] == 0) continue;

            // size크기의 색종이로 덮을 수 없으면 다음 사이즈로
            if (!isValid(r, c, size)) continue;

            paper[size]--;
            fill(r, c, size, 0);
            solution(r, cnt + 1);
            fill(r, c, size, 1);
            paper[size]++;
        }
    }

    private static void findNext(int R) {
        for (int i = R; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1) {
                    nextR = i;
                    nextC = j;
                    return;
                }
            }
        }

        nextR = -1;
        nextC = -1;
    }

    private static boolean isValid(int R, int C, int size) {
        int rUntil = R + size;
        int cUntil = C + size;
        if (rUntil > 10 || cUntil > 10) return false;

        for (int i = R; i < rUntil; i++) {
            for (int j = C; j < cUntil; j++) {
                if (board[i][j] == 0) return false;
            }
        }

        return true;
    }

    private static void fill(int R, int C, int size, int V) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[R + i][C + j] = V;
            }
        }
    }
}
