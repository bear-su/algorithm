package recursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1987 {

    public static int R, C, answer = 1;
    static int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};
    public static char[][] board;
    public static Set<Character> set = new HashSet<>();
    public static int[][] visited; // visited[row][col] -> (row, col) 위치에 도착했을 때 사용한 알파벳

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        board = new char[R][C];
        visited = new int[R][C];
        for (int i = 0; i < R; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        visited[0][0] = 1 << (board[0][0] - 'A');
        set.add(board[0][0]);
        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int cr, int cc) {

        for (int i = 0; i < dr.length; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !set.contains(board[nr][nc])) {
                int route = 1 << board[nr][nc] - 'A';
                if (visited[nr][nc] == (visited[cr][cc] | route)) continue;
                visited[nr][nc] = visited[cr][cc] | route;
                set.add(board[nr][nc]);
                answer = Math.max(answer, set.size());
                DFS(nr, nc);
                set.remove(board[nr][nc]);
            }
        }
    }
}



