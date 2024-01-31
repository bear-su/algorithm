package focus.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1068 {

    static List<List<Integer>> list = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        int root = -1;
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                root = i;
                continue;
            }
            list.get(parent).add(i);
        }

        int deleteNode = sc.nextInt();
        if(deleteNode != root) dfs(root, deleteNode);
        System.out.println(answer);
    }

    private static void dfs(int idx, int deleteNode) {
        if (list.get(idx).isEmpty()) {
            answer++;
            return;
        }
        for (Integer child : list.get(idx)) {
            if (child != deleteNode) dfs(child, deleteNode);
            if (child == deleteNode && list.get(idx).size() == 1) answer++;
        }
    }
}

// 리프 노드의 개수를 구하는 프로그램
// 노드를 지우면 그 노드와 노드의 모든 자손이 트리에서 제거된다.


