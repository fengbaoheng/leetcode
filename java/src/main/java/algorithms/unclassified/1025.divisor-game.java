/*
 * @lc app=leetcode.cn id=1025 lang=java
 *
 * [1025] 除数博弈
 */
import java.util.stream.IntStream;


class Solution {
    public boolean divisorGame(int N) {
        // 存储结果
        boolean[] dp = new boolean[N + 1];

        // N ==1 无解,必输
        dp[1] = false;

        // 递推 从第二个数开始
        for (int i = 2; i < N + 1; i++) {
            final int n = i;

            dp[n] = false;

            IntStream
                    .range(1, i)
                    .filter(x -> n % x == 0) // 寻找可用的x
                    .filter(x -> !dp[n - x]) // 若找到了x, 使n-x后必输, 则此时必赢
                    .findFirst() // 只要找到一个就可结束
                    .ifPresent(x -> dp[n] = true); // 找到了x, 则当前n必赢
        }

        return dp[N];
    }
}

