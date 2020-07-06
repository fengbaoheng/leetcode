/*
 * @lc app=leetcode.cn id=1447 lang=java
 *
 * [1447] 最简分数
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> simplifiedFractions(int n) {
        Set<Fraction> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                set.add(new Fraction(j, i));
            }
        }

        return set.stream().map(Fraction::toString).collect(Collectors.toList());
    }

    private static class Fraction {
        private int a, b;

        public Fraction(int a, int b) {
            this.a = a;
            this.b = b;
            simplify();
        }

        // 化简分数
        private void simplify() {
            int m = gcd(a, b);
            this.a /= m;
            this.b /= m;
        }

        // 求最大公约数
        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Fraction)) return false;
            Fraction fraction = (Fraction) o;
            return a == fraction.a && b == fraction.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return String.format("%d/%d", a, b);
        }
    }
}
// @lc code=end

