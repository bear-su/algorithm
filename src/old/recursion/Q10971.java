package old.recursion;

import java.util.Scanner;

public class Q10971 {
    public static int[][] W;
    public static boolean[] visited;
    public static int N;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N];
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                W[i][j] = sc.nextInt();
            }
        }

        DFS(0,0, 0, 0);

        System.out.println(answer);
    }

    private static void DFS(int start, int node, int count, int sum) {
        if (count == N) {
            if (node == start) {
                answer = Math.min(answer, sum);
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited[i] && W[node][i] != 0) {
                    visited[i] = true;
                    DFS(start, i, count + 1, sum + W[node][i]);
                    visited[i] = false;
                }
            }
        }
    }

}


