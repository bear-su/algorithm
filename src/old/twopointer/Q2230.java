package old.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MAX_VALUE;

        Arrays.sort(arr);
        int right = 0;
        for (int left = 0; left < N; left++) {
            while (arr[right] - arr[left] < M && right < N - 1) right++;
            int diff = arr[right] - arr[left];
            if (diff >= M)
                answer = Math.min(answer, arr[right] - arr[left]);
        }

        System.out.println(answer);

    }
}
