/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        getAns(nums, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void getAns(int[] nums, int start, LinkedList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new LinkedList<>(temp));

        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.addLast(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.removeLast();
        }

    }
}
// @lc code=end

