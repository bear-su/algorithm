package old.divide;

import java.util.Scanner;

public class Q1629 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(solution(A, B, C));
    }

    private static long solution(long A, long B, long C) {

        if (B == 1) return A % C;

        long half = solution(A, B / 2, C);
        if (B % 2 == 0) {
            return (half * half) % C;
        } else {
            return (((half * half) % C) * A) % C;
        }

    }
}
