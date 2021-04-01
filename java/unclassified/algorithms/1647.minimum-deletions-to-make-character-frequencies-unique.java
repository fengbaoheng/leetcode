/*
 * @lc app=leetcode.cn id=1647 lang=java
 *
 * [1647] 字符频次唯一的最小删除次数
 */

// @lc code=start
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        Set<Integer> set = new HashSet<>(26);
        int count = 0;
        for (int num : arr) {
            if (num == 0) {
                continue;
            }

            if (set.contains(num)) {
                do {
                    num--;
                    count++;
                    if (!set.contains(num)) {
                        set.add(num);
                        break;
                    }
                } while (num > 0);
            } else {
                set.add(num);
            }
        }

        return count;
    }
}
// @lc code=end

