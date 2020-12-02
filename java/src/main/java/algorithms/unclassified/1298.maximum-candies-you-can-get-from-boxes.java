/*
 * @lc app=leetcode.cn id=1298 lang=java
 *
 * [1298] 你能从盒子里获得的最大糖果数
 */

// @lc code=start
import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int count = status.length;

        // 初始化每个盒子
        Map<Integer, Box> boxMap = new HashMap<>(count);
        for (int i = 0; i < count; i++) {
            Box box = new Box();
            box.index = i;
            box.opened = status[i] == 1;
            box.candy = candies[i];
            boxMap.put(i, box);
        }


        Queue<Box> queue = new LinkedList<>();
        for (int initialBox : initialBoxes) {
            Box box = boxMap.get(initialBox);
            box.owned = true;
            queue.offer(box);
        }

        while (!queue.isEmpty()) {
            Box box = queue.poll();
            if (!box.canSearch()) {
                continue;
            }

            // 标记搜索过, 防止循环搜索
            box.searched = true;

            // 找到的新盒子
            for (int index : containedBoxes[box.index]) {
                Box b = boxMap.get(index);
                b.owned = true;
                if (b.canSearch()) {
                    queue.offer(b);
                }
            }

            // 找到的新钥匙
            // 可能盒子本来就是打开的状态,不需要钥匙
            for (int index : keys[box.index]) {
                Box b = boxMap.get(index);
                // 盒子没有上锁, 因此找到钥匙不影响任何状态
                if (b.opened) {
                    continue;
                }

                b.opened = true;
                if (b.canSearch()) {
                    queue.offer(b);
                }
            }
        }


        return boxMap.values().stream().mapToInt(Box::getCandy).sum();
    }
    
    
    // 盒子类
    private static class Box {
        private int index;
        private boolean opened;
        private int candy;
        private boolean owned;
        private boolean searched;

        // 糖果数和拥有状态与打开状态有关
        private int getCandy() {
            if (owned && opened) {
                return candy;
            } else {
                return 0;
            }
        }

        public boolean canSearch() {
            return (!searched) && opened && owned;
        }
    }
}
// @lc code=end

