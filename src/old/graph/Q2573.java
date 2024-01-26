package old.graph;

import java.util.*;

public class Q2573 {
    static int N, M;
    static int[][] map;
    static List<Ice> ices = new ArrayList<>();
    static int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};

    static class Ice {
        int row;
        int col;
        int height;

        public Ice(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        input();

        process();

    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        // map 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0) {
                    // 최적화를 위한 ICE 정보 리스트에 저장
                    ices.add(new Ice(i, j, map[i][j]));
                }
            }
        }
    }

    private static void process() {
        for (int year = 1; !ices.isEmpty(); year++) {
            // 빙산 녹이기
            for (Ice ice : ices) {
                for (int i = 0; i < 4; i++) {
                    int nr = ice.row + dr[i];
                    int nc = ice.col + dc[i];
                    if (map[nr][nc] == 0) {
                        ice.height--;
                    }
                }
            }

            // 빙산 녹은 후 0이하인 빙산 제거
            for (int i = 0; i < ices.size(); i++) {
                // 빙산 리스트에서 제거
                Ice ice = ices.get(i);
                if (ice.height <= 0) {
                    map[ice.row][ice.col] = 0;
                    ices.set(i, ices.get(ices.size() - 1));
                    ices.remove(ices.size() - 1);
                    i--;
                }
            }

            // 빙산이 2덩어리 이상인지 확인
            if(!ices.isEmpty()) {
                int cnt = BFS();
                if (cnt != ices.size()) {
                    System.out.println(year);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static int BFS() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        int row = ices.get(0).row;
        int col = ices.get(0).col;
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        int cnt = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (!visited[nr][nc] && map[nr][nc] > 0) {
                    cnt++;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return cnt;

    }


}




