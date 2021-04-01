/*
 * @lc app=leetcode.cn id=1534 lang=java
 *
 * [1534] 统计好三元组
 */

// @lc code=start
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        final int N = arr.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int x = arr[i];
            for (int j = i + 1; j < N; j++) {
                int y = arr[j];
                if (Math.abs(x - y) > a) {
                    continue;
                }

                for (int k = j + 1; k < N; k++) {
                    int z = arr[k];
                    if (Math.abs(y - z) <= b && Math.abs(x - z) <= c) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
// @lc code=end

