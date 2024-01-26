package old.test.f1;

import java.util.Scanner;
import java.util.Stack;

public class Q9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String bomb = sc.next();

        int length = bomb.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() < length) continue;

            boolean isSame = true;
            for (int j = 0; j < length; j++) {
                // 폭탄 문자열 길이 만큼 stack에서 비교해준다.
                if (stack.get(stack.size() - length + j) != bomb.charAt(j)) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                for (int j = 0; j < length; j++) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}