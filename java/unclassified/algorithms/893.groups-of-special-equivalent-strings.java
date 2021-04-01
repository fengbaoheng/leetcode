/*
 * @lc app=leetcode.cn id=893 lang=java
 *
 * [893] 特殊等价字符串组
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        List<int[]> groups = new ArrayList<>(A.length);

        for (String s : A) {
            int[] code = getCode(s);

            boolean findGroup = false;
            for (int[] group : groups) {
                if (equals(group, code)) {
                    findGroup = true;
                    break;
                }
            }

            if (!findGroup) {
                groups.add(code);
            }
        }

        return groups.size();
    }

    private int[] getCode(String s) {
        int[] code = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                code[c - 'a']++;
            } else {
                code[c - 'a' + 26]++;
            }
        }
        return code;
    }

    private boolean equals(int[] c1, int[] c2) {
        for (int i = 0; i < 52; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

