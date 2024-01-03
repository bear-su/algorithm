package recursion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 분할을 이용한 최적화
public class Q1208 {
    static int N,S;

    static int[] numbers;
    static Map<Integer, Integer> map = new HashMap<>();
    static int STATUS = -1;
    static int LEFT = 0;
    static int RIGHT = 1;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());



        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
        }

        STATUS = LEFT;
        solve(0, N/2, 0);

        STATUS = RIGHT;
        solve(N / 2, N, 0);

        if (S == 0) answer--; // S가 0인 경우 두 번 세진다.
        System.out.println(answer);
    }

    private static void solve(int index, int end, int sum) {
        if (index == end) {
            if (STATUS == LEFT) {
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            } else if (STATUS == RIGHT) {
                if (map.containsKey(S - sum)) {
                    answer += map.get(S - sum);
                }
            }
        } else {
            solve(index + 1, end, sum);
            solve(index + 1, end, sum + numbers[index]);
        }
    }
}

