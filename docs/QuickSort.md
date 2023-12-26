# QuickSort 

~~~java
import java.util.Scanner;

public class Q2750 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, N - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (pivot < arr[j]) j--;
            while (i < j && pivot >= arr[i]) i++;
            swap(arr, i, j);
        }

        arr[left] = arr[j];
        arr[j] = pivot;
        return j;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

~~~