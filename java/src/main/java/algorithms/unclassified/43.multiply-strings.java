/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
import java.util.*;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if (num1.length() <= num2.length()) {
            return multi(num1, num2);
        } else {
            return multi(num2, num1);
        }
    }

    private String multi(String s, String l) {
        List<Integer> result = new ArrayList<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            int n = s.charAt(i) - '0';
            List<Integer> multiResult = multi(n, l, s.length() - 1 - i);

            result = add(result, multiResult);
        }

        Collections.reverse(result);
        return numToString(result);
    }

    // 单个数字与一个长数字倒序相乘
    private List<Integer> multi(int n, String num, int zeros) {
        List<Integer> result = new ArrayList<>(num.length() + zeros);

        for (int i = 0; i < zeros; i++) {
            result.add(0);
        }
        
        int s = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int m = num.charAt(i) - '0';
            int next = n * m + s;

            if (next >= 10) {
                s = next / 10;
                next = next % 10;
            } else {
                s = 0;
            }

            result.add(next);
        }

        if (s != 0) {
            result.add(s);
        }

        return result;
    }

    // 两个数组相加
    private List<Integer> add(List<Integer> a, List<Integer> b) {
        int s = 0;
        for (int i = 0; i < b.size(); i++) {
            int numA = i < a.size() ? a.get(i) : 0;
            int numB = b.get(i);

            int num = numA + numB + s;

            if (num >= 10) {
                s = 1;
                b.set(i, num % 10);
            } else {
                s = 0;
                b.set(i, num);
                if (i >= a.size()) {
                    break;
                }
            }
        }

        if (s == 1) {
            b.add(1);
        }

        return b;
    }

    // 转字符串类型
    private String numToString(List<Integer> num) {
        StringBuilder builder = new StringBuilder();
        for (Integer n : num) {
            builder.append(n);
        }
        return builder.toString();
    }
}
// @lc code=end

