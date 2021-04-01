/*
 * @lc app=leetcode.cn id=935 lang=java
 *
 * [935] 骑士拨号器
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    private int mod = 1000_000_007;

    public int knightDialer(int N) {
        long[] pre = new long[10];
        long[] cur = new long[10];

        // 只走1步的情况
        Arrays.fill(pre, 1);

        for (int count = 2; count <= N; count++) {
            for (int i = 0; i < 10; i++) {
                cur[i] = 0;
                int[] next = getNext(i);
                for (int n : next) {
                    cur[i] += pre[n];
                    cur[i] %= mod;
                }
            }

            long[] tmp = pre;
            pre = cur;
            cur = tmp;
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += pre[i];
            result %= mod;
        }
        return (int) result;
    }


    /**
     * @param cur 当前位置
     * @return 下一步可以去的位置
     */
    private int[] getNext(int cur) {
        switch (cur) {
            case 0:
                return new int[]{4, 6};
            case 1:
                return new int[]{8, 6};
            case 2:
                return new int[]{7, 9};
            case 3:
                return new int[]{4, 8};
            case 4:
                return new int[]{9, 0, 3};
            case 5:
                return new int[0];
            case 6:
                return new int[]{0, 1, 7};
            case 7:
                return new int[]{2, 6};
            case 8:
                return new int[]{1, 3};
            case 9:
                return new int[]{4, 2};
            default:
                return new int[]{};
        }
    }
}
// @lc code=end

