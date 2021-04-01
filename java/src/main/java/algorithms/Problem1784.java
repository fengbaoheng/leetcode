package algorithms;

/**
 * 1784.检查二进制字符串字段
 */
class Problem1784 {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        char cur = '1';
        for (char ch : s.toCharArray()) {
            // 从1状态切换为0状态
            if (cur == '1' && ch == '0') {
                count++;
            }
            // 更新当前状态
            cur = ch;
        }

        // 从1状态结束
        if (cur == '1') {
            count++;
        }

        return count <= 1;
    }
}
