package algorithms;

/**
 * 1287.有序数组中出现次数超过25%的元素
 */
class ElementAppearingMoreThan25InSortedArray {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;

        // 一次跳跃25%的间隔进行搜索
        int span = n / 4 + 1;
        for (int i = 0; i < n; i += span) {
            int c = count(arr, i);
            if (c >= span) {
                return arr[i];
            }
        }

        return -1;
    }

    private int count(int[] arr, int index) {
        int num = arr[index];
        int count = 1;

        for (int i = index - 1; i >= 0 && arr[i] == num; i--) {
            count++;
        }

        for (int i = index + 1; i < arr.length && arr[i] == num; i++) {
            count++;
        }

        return count;
    }
}
