/*
 * @lc app=leetcode.cn id=1640 lang=java
 *
 * [1640] 能否连接形成数组
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // 记录每个片段的开头数字
        Map<Integer, int[]> map = new HashMap<>(pieces.length);
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        int index = 0;
        while (index < arr.length) {
            // 查找连接的片段
            int[] piece = map.remove(arr[index]);
            if (piece == null) {
                return false;
            }
            
            index += piece.length;
        }
        
        return true;
    }
}
// @lc code=end

