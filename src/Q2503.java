import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2503 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int s = sc.nextInt();
            int b = sc.nextInt();
            list.add(new int[]{num, s, b});
        }

    }
}
