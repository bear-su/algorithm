package focus.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1086_subtree {

    static List<List<Integer>> list = new ArrayList<>();
    static int[] leaf;
    static int N;
    static int root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        leaf = new int[N + 1];

        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        root = -1;
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                root = i;
                continue;
            }
            list.get(parent).add(i);
        }

        int deleteNode = sc.nextInt();
        if (deleteNode == root) {
            System.out.println(0);
        } else {
            pro(deleteNode);
            System.out.println(dfs(root, -1));
        }
    }

    private static void pro(int deleteNode) {
        for (int i = 0; i < N; i++) {
            if (list.get(i).contains(deleteNode)) {
                list.get(i).remove(list.get(i).indexOf(deleteNode));
            }
        }
    }

    private static int dfs(int node, int parent) {
        if (list.get(node).size() == 0) {
            return 1;
        }
        for (Integer next : list.get(node)) {
            if (parent != next) {
                leaf[node] += dfs(next, node);
            }
        }

        return leaf[node];
    }

}
