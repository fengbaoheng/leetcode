/*
 * @lc app=leetcode.cn id=1410 lang=java
 *
 * [1410] HTML 实体解析器
 */

// @lc code=start
class Solution {
    public String entityParser(String text) {
        text = text.replace("&quot;", "\"");
        text = text.replace("&apos;", "'");
        text = text.replace("&gt;", ">");
        text = text.replace("&lt;", "<");
        text = text.replace("&frasl;", "/");
        text = text.replace("&amp;", "&");
        return text;
    }
}
// @lc code=end

