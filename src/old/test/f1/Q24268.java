package old.test.f1;

import java.util.Scanner;

public class Q24268 {

    static int[] mem;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int d = sc.nextInt();

        visited = new boolean[d];
        mem = new int[d];

        DFS(N, d, 0);
        System.out.println(-1);
    }

    private static void DFS(int N, int d, int L) {
        if (L == d) {
            int result = 0;
            for (int i : mem) {
                result *= d;
                result += i;
            }

            if (result > N) {
                System.out.println(result);
                System.exit(0);
            }
        } else {
            int start = 0;
            if (L == 0) start = 1;
            for (int i = start; i < d; i++) {
                if (!visited[i])  {
                    visited[i] = true;
                    mem[L] = i;
                    DFS(N, d, L + 1);
                    visited[i] = false;
                }
            }
        }
    }

}
