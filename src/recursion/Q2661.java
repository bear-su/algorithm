package recursion;

import java.util.Scanner;

public class Q2661 {

    static int N;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        answer = new int[N];

        solution(0);
    }

    private static boolean solution(int endIndex) {
        if (endIndex == N) {
            for (int i : answer) {
                System.out.print(i);
            }
            System.exit(0);
        } else {
            for (int i = 1; i <= 3; i++) {
                answer[endIndex] = i;
                if (!isBadSequence(endIndex)) {
                    if(solution(endIndex + 1)) return true;
                }
            }
        }
        return false;
    }

    private static boolean isBadSequence(int endIndex) {
        int barrier = (endIndex + 1) / 2;
        for (int length = 1; length <= barrier; length++) {
            boolean isBad = true;
            for (int j = 0; j < length; j++) {
                if (answer[endIndex - j] != answer[endIndex - length - j]) {
                    isBad = false;
                    break;
                }
            }
            if (isBad) return true;
        }

        return false;
    }
}


