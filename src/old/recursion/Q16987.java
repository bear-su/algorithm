package old.recursion;

import java.util.Scanner;

public class Q16987 {

    public static int[][] eggs;
    public static int N;
    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        eggs = new int[N][2];

        for (int i = 0; i < N; i++) {
            int durability = sc.nextInt();
            int weight = sc.nextInt();
            eggs[i][0] = durability;
            eggs[i][1] = weight;
        }

        DFS(0);
        System.out.println(answer);
    }

    private static void DFS(int L) {
        if (N == L) {
            int cnt = 0;
            for (int i = 0; i < eggs.length; i++) {
                if (eggs[i][0] <= 0) cnt++;
            }
            answer = Math.max(cnt, answer);
            return;
        }

        if (eggs[L][0] > 0) {
            boolean flag = false;
            for (int i = 0; i < eggs.length; i++) {
                if (i == L) continue;
                if (eggs[i][0] > 0) {
                    flag = true;
                    eggs[L][0] -= eggs[i][1];
                    eggs[i][0] -= eggs[L][1];
                    DFS(L + 1);
                    eggs[L][0] += eggs[i][1];
                    eggs[i][0] += eggs[L][1];
                }
            }

            if (!flag) DFS(L + 1);
        } else {
            DFS(L + 1);
        }
    }
}
// 내구도 - 무게
// 계란1 - 내구도7 무게5      -> 3
// 계란2 - 내구도3 무게4      -> 깨짐

// 일렬로 놓여있는 계란에 대해 왼ㅉ고부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨야한다.
// 어떻게 해야 최대한 많은 계란을 깰 수 있나?




