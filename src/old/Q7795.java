package old;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q7795 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }

            int[] b = new int[M];
            for (int i = 0; i < M; i++) {
                b[i] = sc.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);


            int sum = 0;
            int j = M - 1;
            for (int i = N - 1; i >= 0; i--) {
                while (j >= 0 && a[i] <= b[j]) j--;
                sum += j + 1;
            }

            System.out.println(sum);
        }

    }
}

// 59
