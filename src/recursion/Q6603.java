package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Q6603 {

    private static int K;
    private static int[] arr;
    private static int[] mem = new int[6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            K = sc.nextInt();
            if (K == 0) break;
            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = sc.nextInt();
            }

            DFS(0, 0);
            System.out.println();
        }
    }

    private static void DFS(int L, int S) {
        if (L == 6) {
            Arrays.stream(mem).forEach(i -> System.out.print(i + " "));
            System.out.println();
        } else {
            for (int i = S; i < arr.length; i++) {
                mem[L] = arr[i];
                DFS(L + 1, i + 1);
            }
        }
    }
}
