/*
 * @lc app=leetcode.cn id=809 lang=java
 *
 * [809] 情感丰富的文字
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int expressiveWords(String S, String[] words) {
        List<int[]> target = getCount(S);

        int count = 0;
        for (String word : words) {
            if (canExpressive(getCount(word), target)) {
                count++;
            }
        }

        return count;
    }

    // 统计字符数量
    private List<int[]> getCount(String s) {
        List<int[]> list = new ArrayList<>();

        for (char c : s.toCharArray()) {
            int n = c - 'a';
            int[] last = list.isEmpty() ? null : list.get(list.size() - 1);
            if (last != null && last[0] == n) {
                last[1]++;
            } else {
                list.add(new int[]{n, 1});
            }
        }

        return list;
    }

    private boolean canExpressive(List<int[]> from, List<int[]> to) {
        if (from.size() != to.size()) {
            return false;
        }

        int size = from.size();
        for (int i = 0; i < size; i++) {
            int[] f = from.get(i);
            int[] t = to.get(i);

            if (!canExpressive(f[0], f[1], t[0], t[1])) {
                return false;
            }
        }

        return true;
    }

    private boolean canExpressive(int fromChar, int fromCount, int toChar, int toCount) {
        // 不符合扩展的前提
        if (fromChar != toChar || fromCount > toCount) {
            return false;
        }

        // 不需要扩展即可
        if (fromCount == toCount) {
            return true;
        }

        // 只要toCount大于3，都可以从fromCount扩展得到
        return toCount >= 3;
    }
}
// @lc code=end

