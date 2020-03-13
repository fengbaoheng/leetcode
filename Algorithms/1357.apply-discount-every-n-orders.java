import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1357 lang=java
 *
 * [1357] 每隔 n 个顾客打折
 */

// @lc code=start
class Cashier {

    /**
     * 打折顾客间隔
     */
    private int n;

    /**
     * 折扣 [0~100]
     */
    private int discount;

    /**
     * 价格
     */
    private Map<Integer, Integer> pricesMap;

    /**
     * 当前顾客数目
     */
    private int count;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.count = 0;

        int len = products.length;
        this.pricesMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            pricesMap.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        int sumPrice = getPrice(product, amount);
        return getDiscount(sumPrice);
    }

    private int getPrice(int[] product, int[] amount) {
        int sum = 0;

        for (int i = 0; i < product.length; i++) {
            sum += pricesMap.get(product[i]) * amount[i];
        }

        return sum;
    }

    private double getDiscount(double price) {
        // 顾客计数
        count++;
        count %= n;

        // 打折后的价格
        if (count == 0) {
            price -= price * discount / 100;
        }

        return price;
    }
}

/**
 * Your Cashier object will be instantiated and called as such: Cashier obj =
 * new Cashier(n, discount, products, prices); double param_1 =
 * obj.getBill(product,amount);
 */
// @lc code=end
