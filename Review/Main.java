package LeetCode.Review;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += getZeroNum(i);
        }
        System.out.println(cnt);
    }

    public static int getZeroNum(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n / 5);
            n /= 5;
        }
        return cnt;
    }
}
