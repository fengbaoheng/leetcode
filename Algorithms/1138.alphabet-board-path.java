/*
 * @lc app=leetcode.cn id=1138 lang=java
 *
 * [1138] 字母板上的路径
 */

// @lc code=start
import java.util.Arrays;


class Solution {
    private static final String[][] PATH = new String[26][26];
    private static final int Z_ROW = 5;

    public String alphabetBoardPath(String target) {
        // 从0,0开始即从a开始
        char pre = 'a';
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : target.toCharArray()) {
            // 计算路径
            String path = getPath(pre, c);
            stringBuilder.append(path);
            // 添加"!"
            stringBuilder.append('!');
            
            pre = c;
        }

        return stringBuilder.toString();
    }


    private int[] getPos(int index) {
        int x = index / 5;
        int y = index % 5;
        return new int[]{x, y};
    }

    /**
     * 计算路径
     *
     * @param start 起始字符
     * @param end   结束字符
     * @return 路径
     */
    private String getPath(char start, char end) {
        // 同一个位置
        if (start == end) {
            return "";
        }

        int s = start - 'a';
        int e = end - 'a';

        // 缓存
        if (PATH[s][e] == null) {
            PATH[s][e] = getPath(getPos(s), getPos(e));
        }

        return PATH[s][e];
    }

    /**
     * 给定坐标求移动路径
     *
     * @param start 起始坐标
     * @param end   结束坐标
     * @return 路径
     */
    private String getPath(int[] start, int[] end) {
        int rStart = start[0];
        int cStart = start[1];
        int rEnd = end[0];
        int cEnd = end[1];

        StringBuilder path = new StringBuilder();

        int dR = rEnd - rStart;
        int dC = cEnd - cStart;

        // 特殊注意z行
        if (rEnd != Z_ROW) {
            // 先移动行再移动列
            path.append(MoveRow(dR));
            path.append(MoveCol(dC));
        } else {
            //  先移动列再移动行
            path.append(MoveCol(dC));
            path.append(MoveRow(dR));
        }

        return path.toString();
    }

    // 移动行
    private char[] MoveRow(int dR) {
        char[] result = new char[Math.abs(dR)];
        Arrays.fill(result, dR > 0 ? 'D' : 'U');
        return result;
    }

    // 移动列
    private char[] MoveCol(int dC) {
        char[] result = new char[Math.abs(dC)];
        Arrays.fill(result, dC > 0 ? 'R' : 'L');
        return result;
    }
}
// @lc code=end

