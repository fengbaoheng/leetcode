package algorithms;

/**
 * 1652.拆炸弹
 */
class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] sum = new int[n];

        // k==0情况
        if (k == 0) {
            return sum;
        }

        // 计算前缀累计和
        sum[0] = code[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + code[i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = decrypt(sum, i, k);
        }

        return result;
    }

    private int decrypt(int[] sum, int start, int k) {
        int n = sum.length;
        if (k > 0) {
            int i = start + 1;
            int j = start + k;
            if (j >= n) {
                return getRangeSum(sum, i, n - 1) + getRangeSum(sum, 0, j - n);
            } else {
                return getRangeSum(sum, i, j);
            }
        } else {
            int i = start + k;
            int j = start - 1;
            if (i < 0) {
                if (j < 0) {
                    return getRangeSum(sum, i + n, j + n);
                } else {
                    return getRangeSum(sum, i + n, n - 1) + getRangeSum(sum, 0, j);
                }
            } else {
                return getRangeSum(sum, i, j);
            }
        }
    }

    private int getRangeSum(int[] sum, int i, int j) {
        return i == 0 ? sum[j] : sum[j] - sum[i - 1];
    }
}