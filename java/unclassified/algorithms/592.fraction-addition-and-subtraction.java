/*
 * @lc app=leetcode.cn id=592 lang=java
 *
 * [592] 分数加减运算
 */

// @lc code=start
import java.util.*;

class Solution {
    public String fractionAddition(String expression) {
        List<Fraction> fractions = splitFraction(expression);

        Fraction res = new Fraction();
        fractions.forEach(res::add);

        return res.toString();
    }

    private List<Fraction> splitFraction(String expression) {
        List<Fraction> fractions = new LinkedList<>();

        int begin = 0;
        for (int i = 1; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-') {
                fractions.add(new Fraction(expression.substring(begin, i)));
                begin = i;
            }
        }
        fractions.add(new Fraction(expression.substring(begin)));

        return fractions;
    }

    private static class Fraction {
        public int a;
        public int b;

        public Fraction(String str) {
            String[] p = str.split("/");
            a = Integer.parseInt(p[0]);
            b = Integer.parseInt(p[1]);
        }

        public Fraction() {
            a = 0;
            b = 1;
        }

        public void add(Fraction target) {
            a = a * target.b + target.a * this.b;
            b *= target.b;
            simplify();
        }

        // 化简分数
        public void simplify() {
            if (a == 0) {
                b = 1;
                return;
            }

            int sign = a > 0 ? 1 : -1;

            a = Math.abs(a);

            int m;
            if (a < b) {
                m = gcd(a, b);
            } else {
                m = gcd(b, a);
            }

            a = sign * a / m;
            b = b / m;
        }

        // 求最大公约数
        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }


        @Override
        public String toString() {
            return String.format("%d/%d", a, b);
        }
    }
}
// @lc code=end

