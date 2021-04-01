/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
import java.util.*;


class Solution {
    public int maxProduct(String[] words) {
        // 单词转为位标记数字
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int num = getBitNumber(word);
            map.merge(num, word.length(), Math::max);
        }

        int max = 0;
        List<Integer> nums = new ArrayList<>(map.keySet());
        for (int i = 0; i < nums.size() - 1; i++) {
            int num1 = nums.get(i);
            int value1 = map.get(num1);
            
            for (int j = i + 1; j < nums.size(); j++) {
                int num2 = nums.get(j);
                int value2 = map.get(num2);
                // 位操作判断是否有重复
                if ((num1 & num2) == 0) {
                    max = Math.max(max, value1 * value2);
                }
            }
        }

        return max;

    }


    private int getBitNumber(String str) {
        int result = 0;
        for (char c : str.toCharArray()) {
            result |= 1 << (c - 'a');
        }
        return result;
    }
}
// @lc code=end

