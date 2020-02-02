/*
 * @lc app=leetcode.cn id=1333 lang=java
 *
 * [1333] 餐厅过滤器
 */

// @lc code=start
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .map(Restaurant::new)
                .filter(d -> d.filterVeganFriendly(veganFriendly))
                .filter(d -> d.filterPrice(maxPrice))
                .filter(d -> d.filterDistance(maxDistance))
                .sorted()
                .map(Restaurant::getId)
                .collect(Collectors.toList());
    }
}

class Restaurant implements Comparable<Restaurant> {
    private int id;
    private int rating;
    private int veganFriendly;
    private int price;
    private int distance;

    public Restaurant(int[] info) {
        this.id = info[0];
        this.rating = info[1];
        this.veganFriendly = info[2];
        this.price = info[3];
        this.distance = info[4];
    }

    public int getId() {
        return id;
    }

    /**
     * 筛选素食
     *
     * @param shouldFriendly 是否需要符合素食友好条件
     * @return 筛选结果
     */
    public boolean filterVeganFriendly(int shouldFriendly) {
        if (shouldFriendly == 0) {
            return true;
        }
        return this.veganFriendly == 1;
    }

    /**
     * 筛选价格
     *
     * @param maxPrice 最大价格
     * @return 筛选结果
     */
    public boolean filterPrice(int maxPrice) {
        return this.price <= maxPrice;
    }

    /**
     * 筛选距离
     *
     * @param maxDistance 最大距离
     * @return 筛选结果
     */
    public boolean filterDistance(int maxDistance) {
        return this.distance <= maxDistance;
    }


    @Override
    public int compareTo(Restaurant o) {
        if (this.rating != o.rating) {
            // 先按rating从高到低排序
            return this.rating > o.rating ? -1 : 1;
        } else {
            // rating相同按id从高到低排序
            return this.id > o.id ? -1 : 1;
        }
    }
}
// @lc code=end

