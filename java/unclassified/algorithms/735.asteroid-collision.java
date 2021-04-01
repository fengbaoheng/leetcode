/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();

        List<Integer> result = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid <= 0) {
                // 左移行星, 和栈内右移行星依次碰撞
                boolean exploded = false;
                while (!stack.isEmpty() && !exploded) {
                    int sum = stack.peek() + asteroid; // 取出行星进行碰撞
                    if (sum > 0) {
                        // 自身爆炸
                        exploded = true;
                    }else if(sum == 0){
                        // 同时爆炸
                        exploded = true;
                        stack.pop();
                    }else{
                        // 继续碰撞
                        stack.pop();
                    }
                }

                if (!exploded) {
                    result.add(asteroid); // 碰撞完依然未爆炸
                }
            } else {
                // 右移行星直接入栈, 等待碰撞
                stack.push(asteroid);
            }
        }

        // 反转栈内行星
        List<Integer> restAsteroids = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            restAsteroids.add(stack.pop());
        }
        Collections.reverse(restAsteroids);


        result.addAll(restAsteroids);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

