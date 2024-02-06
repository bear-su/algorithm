package review;

import java.util.ArrayList;
import java.util.List;

public class P688645 {

    class Solution {
        final int DOWN = 0, RIGHT = 1, UP = 2;
        final int DIRECTION = 3;
        public int[] solution(int n) {
            int[][] mem = new int[n][n];

            int count = 1;
            int r = -1;
            int c = 0;
            for (int direction = 0; direction < n; direction++) {
                for (int start = direction; start < n; start++) {
                    if (direction % DIRECTION == DOWN) {
                        r += 1;
                    } else if (direction % DIRECTION == RIGHT) {
                        c += 1;
                    } else {
                        r -= 1;
                        c -= 1;
                    }

                    mem[r][c] = count++;
                }
            }

            List<Integer> list = new ArrayList<>();
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mem[i][j] != 0) list.add(mem[i][j]);
                }
            }

            int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

            return answer;
        }
    }
}
