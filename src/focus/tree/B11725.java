package focus.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B11725 {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        answer = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited[1] = true;
        dfs(1);


        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void dfs(int idx) {
        for (Integer next : list.get(idx)) {
            if (!visited[next]) {
                visited[next] = true;
                answer[next] = idx;
                dfs(next);
            }
        }
    }
}
