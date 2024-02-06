package review;

class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return answer;
    }

    private boolean zip(int[][] arr, int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[r][c] != arr[i][j]) return false;
            }
        }
        return true;
    }

    private void quad(int[][] arr, int r, int c, int size) {
        if (zip(arr, r, c, size)) {
            if (arr[r][c] == 1) answer[1]++;
            else answer[0]++;
            return;
        }
        quad(arr, r, c, size / 2);
        quad(arr, r, c + size / 2, size / 2);
        quad(arr, r + size / 2, c, size / 2);
        quad(arr, r + size / 2, c + size / 2, size / 2);
    }

}
