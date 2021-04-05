package algorithms;

/**
 * 1812.判断国际象棋棋盘中一个格子的颜色
 */
public class Problem1812 {

    static class Solution {
        public boolean squareIsWhite(String coordinates) {
            int x = coordinates.charAt(0) - 'a';
            int y = coordinates.charAt(1) - '1';
            return x % 2 != y % 2;
        }
    }


}