/*
 * @lc app=leetcode.cn id=1441 lang=java
 *
 * [1441] 用栈操作构建数组
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new LinkedList<>();

        int cur = 1;
        for (int t : target) {
            while (cur < t) {
                result.add("Push");
                result.add("Pop");
                cur++;
            }

            result.add("Push");
            cur++;
        }

        return result;
    }
}
// @lc code=end

