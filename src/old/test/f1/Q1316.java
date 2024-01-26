package old.test.f1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            boolean answer = check(str);
            if (answer) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean check(String str) {
        Set<Character> set = new HashSet<>();
        set.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            char prior = str.charAt(i - 1);
            if (c == prior) continue;
            else {
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        return true;
    }
}
