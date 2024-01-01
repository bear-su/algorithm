package binarysearch;

import java.util.Scanner;

public class Q6236J {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;
        int left = 1, right = N * 10_000;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean possible = isPossible(arr, mid, M);
            if (possible) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else left = mid + 1;
        }

        System.out.println(answer);
    }

    private static boolean isPossible(int[] arr, int money, int M) {
        int dayCount = 1;
        int nowMoney = money;
        for (int needMoney : arr) {
            if (money < needMoney) return false;
            if (nowMoney < needMoney) {
                dayCount++;
                nowMoney = money;
            }
            nowMoney -= needMoney;
        }

        return dayCount <= M;
    }
}
