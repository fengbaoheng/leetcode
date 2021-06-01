package algorithms;

/**
 * 1837.K 进制表示下的各位数字总和
 */
public class Problem1837 {

    class Solution {
        public int sumBase(int n, int k) {
            String s = Integer.toString(n, k);
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += c - '0';
            }
            return sum;
        }
    }


}