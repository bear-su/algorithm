package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long answer = -1;
        long left = 1;
        long right = Integer.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int n : arr) {
                count += n / mid;
            }

            if (count < N) {
                right = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
