/*
 * @lc app=leetcode.cn id=953 lang=java
 *
 * [953] 验证外星语词典
 */

// @lc code=start
class Solution {
    // 外星顺序
    private int[] orderArr = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }

        // 建立新索引顺序
        createNewOrder(order);

        // 依次比较相邻两个单词是否正确
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];

            if (!isOrdered(pre, cur)) {
                return false;
            }
        }

        return true;
    }

    // 建立新的索引顺序
    private void createNewOrder(String order) {
        for (int i = 0; i < order.toCharArray().length; i++) {
            orderArr[order.charAt(i) - 'a'] = i;
        }
    }


    // 比较两个word是否正确
    private boolean isOrdered(String pre, String cur) {
        int preLen = pre.length();
        int curLen = cur.length();
        int maxLen = Math.max(preLen, curLen);

        for (int i = 0; i < maxLen; i++) {
            // 如果一个单词长度较短, 则字符顺序返回-1
            int preOrder = i >= preLen ? -1 : orderArr[pre.charAt(i) - 'a'];
            int curOrder = i >= curLen ? -1 : orderArr[cur.charAt(i) - 'a'];

            if (preOrder < curOrder) {
                return true;
            } else if (preOrder > curOrder) {
                return false;
            }
        }

        return true;
    }

}
// @lc code=end

