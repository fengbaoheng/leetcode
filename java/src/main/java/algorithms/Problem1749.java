package algorithms;

/**
 * 1749.任意子数组和的绝对值的最大值
 */

class Problem1749 {
    public int maxAbsoluteSum(int[] nums) {

        int maxAbsolute = 0;

        // 累计值,尽可能让min更小，让max更大
        int min = 0, max = 0;

        for (int num : nums) {
            // 累积值
            min += num;
            max += num;

            // 判断是否放弃累积值，直接使用num可以取得更优效果
            if (num >= 0 && num > max) {
                max = num;
            }
            if (num <= 0 && num < min) {
                min = num;
            }

            // 刷新最大绝对值
            maxAbsolute = Math.max(maxAbsolute, max);
            maxAbsolute = Math.max(maxAbsolute, Math.abs(min));
        }

        return maxAbsolute;
    }
}
