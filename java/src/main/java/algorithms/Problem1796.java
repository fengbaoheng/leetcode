package algorithms;

/**
 * 1796.字符串中第二大的数字
 */
public class Problem1796 {

    class Solution {
        public int secondHighest(String s) {
            boolean[] nums = new boolean[10];
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    nums[c - '0'] = true;
                }
            }

            boolean findFirst = false;
            for (int i = 9; i >= 0; i--) {
                if (nums[i]) {
                    if (findFirst) {
                        return i;
                    } else {
                        findFirst = true;
                    }
                }
            }

            return -1;
        }
    }


}