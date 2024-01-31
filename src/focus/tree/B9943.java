package focus.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B9943 {

    static int K;
    static int[] arr;
    static List<List<Integer>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt(); // 깊이
        int until = (1 << K) - 1;
        arr = new int[until];
        for (int i = 0; i < until; i++) {
            arr[i] = sc.nextInt();
        }

        list = new ArrayList<>();
        for (int i = 0; i < K; i++) list.add(new ArrayList<>());

        dfs(0, until, 0);

        for (int i = 0; i < K; i++) {
            for (int n : list.get(i)) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int start, int end, int depth) {
        if (depth == K) return;

        int middle = (start + end) / 2;

        list.get(depth).add(arr[middle]);

        dfs(start, middle - 1, depth + 1);
        dfs(middle + 1, end, depth + 1);
    }
}
