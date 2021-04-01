/*
 * @lc app=leetcode.cn id=830 lang=java
 *
 * [830] 较大分组的位置
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        int len = S.length();
        List<List<Integer>> result = new ArrayList<>();
        if (len < 3) {
            return result;
        }

        char repeat = ' ';
        int start = -1;

        for (int i = 0; i < len; i++) {
            char ch = S.charAt(i);

            // 出现了与之前并不重复字符
            if (ch != repeat) {
                // 判断之前重复字符是否超过了3, 并加入结果中
                if (i - start >= 3) {
                    result.add(Arrays.asList(start, i - 1));
                }

                repeat = ch;
                start = i;
            }
        }

        // 最后结尾可能重复
        if (S.charAt(len - 1) == repeat && start <= len - 3) {
            result.add(Arrays.asList(start, len - 1));
        }


        return result;
    }
}
// @lc code=end

