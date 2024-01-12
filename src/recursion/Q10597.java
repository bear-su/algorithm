package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q10597 {
    static boolean[] visited = new boolean[101]; // 1 ~ 50사이의 숫자
    static List<Integer> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        N = input.length() > 9 ? 9 + (input.length() - 9) / 2 : input.length();

        visited[0] = true;
        solution(input, 0);
    }

    public static void solution(String input, int index) {
        if (index == input.length()) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.exit(0);
        }

        int target1 = Integer.parseInt(input.substring(index, index + 1));
        if (target1 <= N && !visited[target1]) {
            visited[target1] = true;
            list.add(target1);
            solution(input, index + 1);
            visited[target1] = false;
            list.remove(list.size() - 1);
        }

        if (index + 1 >= input.length()) return;

        int target2 = Integer.parseInt(input.substring(index, index + 2));
        if (target2 <= N && !visited[target2]) {
            visited[target2] = true;
            list.add(target2);
            solution(input, index + 2);
            visited[target2] = false;
            list.remove(list.remove(list.size() - 1));
        }

    }
}
