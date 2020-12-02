/*
 * @lc app=leetcode.cn id=1526 lang=java
 *
 * [1526] 形成目标数组的子数组最少增加次数
 */

// @lc code=start
class Solution {
    public int minNumberOperations(int[] target) {
        // 逆向思考，从target一直减少直到全为0
        
        // limit为可以和左侧一同删除的数值大小
        int limit = 0;
        int result = 0;

        for (int num : target) {
            if (num > limit) {
                result += num - limit;
            }
            limit = num;
        }

        return result;
    }
}
// @lc code=end

