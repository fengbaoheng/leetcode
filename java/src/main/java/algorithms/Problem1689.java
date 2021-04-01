package algorithms;

/**
 * 1689.十-二进制数的最少数目
 */
class Problem1689 {
    public int minPartitions(String n) {
        boolean[] nums = new boolean[10];

        for (char c : n.toCharArray()) {
            int i = c - '0';
            nums[i] = true;
        }

        for (int i = 9; i > 0; i--) {
            if (nums[i]) {
                return i;
            }
        }

        return 0;
    }
}
