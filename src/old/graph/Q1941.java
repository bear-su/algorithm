package old.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// S,Y가 적힌 5 * 5 크기의 배열이 주어질 때 7개를 선택한 조합의 경우의 수 중에서 S가 4개 이상인 경우
public class Q1941 {

    static char[][] map = new char[5][5];
    static int[] rArr = new int[25];
    static int[] cArr = new int[25];
    static int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            map[i] = sc.next().toCharArray();
        }

        // 학생 -> 좌표 위치 기록
        for (int i = 0; i < 25; i++) {
            rArr[i] = i / 5;
            cArr[i] = i % 5;
        }

        combination(new int[7], 0, 0);

        System.out.println(answer);

    }

    private static void combination(int[] combi, int combiIndex, int studentNumber) {
        if (combiIndex == 7) {
            bfs(combi);
            return;
        }

        if (studentNumber == 25) {
            return;
        }

        combi[combiIndex] = studentNumber;
        combination(combi, combiIndex + 1, studentNumber + 1);
        combination(combi, combiIndex, studentNumber + 1);
    }

    private static void bfs(int[] comb) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[7];

        queue.add(comb[0]);
        visited[0] = true;

        int cnt = 1, sCnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (map[rArr[cur]][cArr[cur]] == 'S') {
                sCnt++;
            }

            for (int i = 0; i < 4; i++) {
                for (int next = 1; next < 7; next++) {
                    // 다음 방문할 학생이 방문하지 않았고 상하좌우에 위치하면 방문
                    if (!visited[next] && rArr[cur] + dr[i] == rArr[comb[next]] && cArr[cur] + dc[i] == cArr[comb[next]]) {
                        queue.add(comb[next]);
                        visited[next] = true;
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 7 && sCnt >= 4) {
            answer++;
        }
    }


}
