package old;

import java.util.Scanner;

public class Q1475 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();

        int[] mem = new int[10];
        for (char c : N.toCharArray()) {
            int index = c - '0';
            mem[index]++;
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (mem[i] > answer && i != 6 && i != 9) {
                answer = mem[i];
            }
        }

        int temp = Math.round((float)(mem[6] + mem[9]) / 2);
        if (answer < temp) answer = temp;

        System.out.println(answer);
    }
}
// 27