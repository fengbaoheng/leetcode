/*
 * @lc app=leetcode.cn id=816 lang=java
 *
 * [816] 模糊坐标
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);

        int len = S.length();
        List<String> result = new LinkedList<>();
        for (int i = 1; i < len; i++) {
            String xStr = S.substring(0, i);
            String yStr = S.substring(i, len);

            for (String x : getNumList(xStr)) {
                for (String y : getNumList(yStr)) {
                    result.add(String.format("(%s, %s)", x, y));
                }
            }
        }

        return result;
    }

    private List<String> getNumList(String str) {
        int len = str.length();
        List<String> result = new LinkedList<>();

        for (int i = 1; i <= len; i++) {
            String partInteger = str.substring(0, i);
            String partDecimal = str.substring(i, len);
            if (isIntegerValid(partInteger) && isDecimalValid(partDecimal)) {
                result.add(toNumString(partInteger, partDecimal));
            }
        }

        return result;
    }

    // 验证整数部分
    private boolean isIntegerValid(String partInteger) {
        int len = partInteger.length();
        // 整数部分长度大于0
        if (len == 0) {
            return false;
        }

        // 整数部分如果长度超过1，则不准以0开头
        if (len > 1 && partInteger.charAt(0) == '0') {
            return false;
        }

        return true;
    }


    // 验证小数部分
    private boolean isDecimalValid(String partDecimal) {
        int len = partDecimal.length();
        // 不包含小数
        if (len == 0) {
            return true;
        }

        // 最后1位不允许为0
        // x.0 x.110
        if (partDecimal.charAt(len - 1) == '0') {
            return false;
        }

        return true;
    }

    private String toNumString(String partInteger, String partDecimal) {
        StringBuilder builder = new StringBuilder();
        builder.append(partInteger);
        if (!partDecimal.isEmpty()) {
            builder.append('.');
            builder.append(partDecimal);
        }
        return builder.toString();
    }
}
// @lc code=end

