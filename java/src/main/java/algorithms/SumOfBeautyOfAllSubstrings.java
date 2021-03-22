package algorithms;

/**
 * 1781.所有子字符串美丽值之和
 */
class SumOfBeautyOfAllSubstrings {
    public int beautySum(String s) {
        final int n = s.length();

        // 计算前缀和
        int[][] count = new int[n][26];
        count[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; i++) {
            System.arraycopy(count[i - 1], 0, count[i], 0, 26);
            count[i][s.charAt(i) - 'a']++;
        }

        // 遍历所有子字符串
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                sum += getBeauty(count, i, j);
            }
        }

        return sum;

    }

    private int getBeauty(int[][] arr, int i, int j) {
        int[] minmax = i == 0 ? getMinMax(arr[j]) : getMinMax(arr[i - 1], arr[j]);
        return minmax[1] - minmax[0];
    }

    private int[] getMinMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int c : arr) {
            if (c == 0) {
                continue;
            }
            if (c > max) {
                max = c;
            }
            if (c < min) {
                min = c;
            }
        }
        return new int[]{min, max};
    }

    private int[] getMinMax(int[] a, int[] b) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int c = b[i] - a[i];
            if (c == 0) {
                continue;
            }
            if (c > max) {
                max = c;
            }
            if (c < min) {
                min = c;
            }
        }
        return new int[]{min, max};
    }
}
