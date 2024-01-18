package test.f1;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1167 {

    static List<List<Node>> list = new ArrayList<>();
    static boolean[] visited;

    static class Node {
        int index;
        int distance;
        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            int current = sc.nextInt();
            while (true) {
                int next = sc.nextInt();
                if (next == -1) {
                    break;
                }
                int distance = sc.nextInt();
                list.get(current).add(new Node(next, distance));
                list.get(next).add(new Node(current, distance));
            }
        }

        visited[1] = true;
        DFS(1, 0);

        max = 0;
        visited = new boolean[V + 1];
        visited[maxNode] = true;
        DFS(maxNode, 0);
        System.out.println(max);
    }

    static int max = 0;
    static int maxNode = -1;

    private static void DFS(int N, int distance) {
        if (distance > max) {
            max = distance;
            maxNode = N;
        }
        for (Node node : list.get(N)) {
            if (!visited[node.index]) {
                visited[node.index] = true;
                DFS(node.index, distance + node.distance);
            }
        }
    }
}
