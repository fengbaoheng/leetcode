/*
 * @lc app=leetcode.cn id=762 lang=java
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
    static boolean[] prime = new boolean[33];

    static {
        for (int i = 2; i <= 32; i++) {
            prime[i] = isPrime(i);
        }
    }

    public int countPrimeSetBits(int L, int R) {
        return (int) IntStream.rangeClosed(L, R)
                .map(this::bitCount)
                .filter(count -> prime[count])
                .count();
    }

    private static boolean isPrime(int x) {
        int sqrt = (int) Math.sqrt(x);
        for (int i = 2; i <= sqrt; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int bitCount(int x) {
        int count = 0;
        while (x != 0) {
            count += x & 1;
            x = x >> 1;
        }
        return count;
    }
}
// @lc code=end

