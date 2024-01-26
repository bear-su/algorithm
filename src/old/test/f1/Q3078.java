package old.test.f1;

import java.util.*;

public class Q3078 {

    // 모든 학생은 자신과 반 등수의 차이가 K를 넘으면 친구가 아니다.
    // 좋은 친구는 이름의 길이가 같아야 한다.
    // 좋은 친구가 몇 쌍이나 있냐? 좋은 친구는 등수의 차이가 K보다 작거나 같으 면서 이름의 길이가 같은 친구

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        int[] count = new int[21];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int next = sc.next().length();
            sum += count[next];
            queue.add(next);
            count[next]++;

            if (queue.size() > K) {
                int out = queue.poll();
                count[out]--;
            }
        }

        System.out.println(sum);
    }
}
