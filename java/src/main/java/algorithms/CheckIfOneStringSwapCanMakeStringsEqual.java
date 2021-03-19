package algorithms;

/**
 * 1790.仅执行一次字符串交换能否使两个字符串相等
 */

class CheckIfOneStringSwapCanMakeStringsEqual {
    private static final int ZERO = -1;
    private static final int FINISH = -2;

    public boolean areAlmostEqual(String s1, String s2) {
        int index = ZERO;
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            // 出现不一致现象
            if (index == FINISH) {
                // 已经调整了一次，无法下一次调整
                return false;
            }

            // 发现第一个需要调整的地方
            if (index == ZERO) {
                index = i;
                continue;
            }

            // 判断位置i和index两个位置调换
            if (s1.charAt(i) == s2.charAt(index) && s1.charAt(index) == s2.charAt(i)) {
                index = FINISH;
            } else {
                return false;
            }
        }

        return index == FINISH || index == ZERO;
    }
}
