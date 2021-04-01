/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int numberOfBoomerangs(int[][] points) {
        // 构造回旋镖对象
        List<Boomerang> boomerangList = Arrays
                .stream(points)
                .map(Boomerang::new)
                .collect(Collectors.toList());

        // 双层循环依次计算当前和后续所有回旋镖间的距离
        for (int i = 0; i < boomerangList.size() - 1; i++) {
            Boomerang boomerang = boomerangList.get(i);

            // 依次计算距离
            for (int j = i + 1; j < boomerangList.size(); j++) {
                Boomerang nextBoomerang = boomerangList.get(j);
                int distance = boomerang.countDistance(nextBoomerang);

                boomerang.addDistance(distance);
                nextBoomerang.addDistance(distance);
            }
        }

        // 返回对数总和
        return boomerangList
                .stream()
                .mapToInt(Boomerang::getCount)
                .sum();

    }
}

// 回旋镖类
class Boomerang {
    private final int x;
    private final int y;

    private Map<Integer, Integer> distanceMap = new HashMap<>();

    Boomerang(int[] point) {
        this.x = point[0];
        this.y = point[1];
    }

    // 计算距离
    int countDistance(Boomerang boomerang) {
        int dx = x - boomerang.x;
        int dy = y - boomerang.y;
        return dx * dx + dy * dy;
    }

    // 保存距离
    void addDistance(int distance) {
        distanceMap.put(distance, 1 + distanceMap.getOrDefault(distance, 0));
    }

    // 返回旋镖数量
    int getCount() {
        return distanceMap
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .filter(count -> count > 1) // 相等距离的回旋镖至少超过两个
                .map(count -> count * (count - 1)) // 排列组合
                .sum();
    }

}
// @lc code=end

