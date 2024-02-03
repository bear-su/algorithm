package focus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 전위 순회한 결과 -> 후위 순회 결과
public class Q5639 {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int no) {
            this.data = no;
        }

        public void insert(int data) {
            if (this.data > data) {
                if (this.left == null) this.left = new Node(data);
                else this.left.insert(data);
            } else {
                if (this.right == null) this.right = new Node(data);
                else this.right.insert(data);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String data;
        while (true) {
            data = br.readLine();
            if (data == null || data.equals("")) break;
            root.insert(Integer.parseInt(data));
        }

        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }

        System.out.println(node.data);
    }
}
