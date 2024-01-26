package old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
// k개의 접시를 연속해서 먹으면, 발급된 쿠폰의 초밥을 하나 무료로 제공한다.
public class Q15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] dish = new int[N];
        for (int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        // 어떤 초밥을 얼만큼 먹었는지
        int[] dishCount = new int[d + 1];
        int kind = 0;

        // init
        for (int i = 0; i < k - 1; i++) {
            int current = dish[i];
            if (dishCount[current]++ == 0) {
                kind++;
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (dishCount[dish[(i + k - 1) % N]]++ == 0) kind++;
            answer = Math.max(answer, kind + (dishCount[c] == 0 ? 1 : 0));
            if (--dishCount[dish[i]] == 0) kind--;
        }

        System.out.println(answer);
    }
}
// 1:33
