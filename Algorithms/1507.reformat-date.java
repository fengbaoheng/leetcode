/*
 * @lc app=leetcode.cn id=1507 lang=java
 *
 * [1507] 转变日期格式
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<String, String> map = new HashMap<>();

    static {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < months.length; i++) {
            map.put(months[i], String.format("%02d", i + 1));
        }
    }

    public String reformatDate(String date) {
        String[] s = date.split(" ");
        String day = getDay(s[0]);
        String month = map.get(s[1]);
        String year = s[2];

        return String.format("%s-%s-%s", year, month, day);
    }

    private String getDay(String date) {
        if (Character.isLetter(date.charAt(1))) {
            return "0" + date.substring(0, 1);
        } else {
            return date.substring(0, 2);
        }
    }
}
// @lc code=end

