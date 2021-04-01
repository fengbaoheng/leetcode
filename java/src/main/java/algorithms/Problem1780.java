package algorithms;

/**
 * 1780.判断一个数字是否可以表示成三的幂的和
 */
class Problem1780 {
    public boolean checkPowersOfThree(int n) {
        // 使用三进制表示数字，每个进制位上只能为1或0
        return !Integer.toString(n, 3).contains("2");
    }
}
