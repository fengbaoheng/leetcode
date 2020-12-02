/*
 * @lc app=leetcode.cn id=1310 lang=java
 *
 * [1310] 子数组异或查询
 */

// @lc code=start
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;

        // 从左到右依次异或
        int[] xor = new int[len];
        xor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor[i] = xor[i - 1] ^ arr[i];
        }

        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int p = query[0];
            int q = query[1];
            int result = p == 0 ? xor[q] : xor[p - 1] ^ xor[q];
            results[i] = result;
        }

        return results;
    }
}
// @lc code=end

