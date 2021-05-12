package algorithms;

/**
 * 1848.到目标元素的最小距离
 */
public class Problem1848 {

    class Solution {
        public int getMinDistance(int[] nums, int target, int start) {
            int step = 0;
            while (true) {
                if (findTarget(nums, target, start - step, start + step)) {
                    return step;
                }
                step++;
            }
        }

        private boolean findTarget(int[] nums, int target, int i, int j) {
            return (i >= 0 && nums[i] == target) || (j < nums.length && nums[j] == target);
        }
    }

}