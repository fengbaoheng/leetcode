/*
 * @lc app=leetcode.cn id=1352 lang=java
 *
 * [1352] 最后 K 个数的乘积
 */

// @lc code=start
import java.util.*;

class ProductOfNumbers {
    // 记录所有数字的乘积
    List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
    }

    public void add(int num) {
        // 若为0则清空
        if (num == 0) {
            products.clear();
        } else {
            // 计算前缀积
            int size = products.size();
            if (size == 0) {
                products.add(num);
            } else {
                products.add(num * products.get(size - 1));
            }
        }
    }

    public int getProduct(int k) {
        int size = products.size();
        
        // 说明最后k个数字当中遇到0被清空过
        // 因此才导致k>size
        if (k > size) {
            return 0;
        }

        int start = products.size() - k - 1;
        int result = products.get(size - 1);
        if (start >= 0) {
            result /= products.get(start);
        }

        return result;
    }
}
// @lc code=end

