package algorithms;

/**
 * 1855.下标对中的最大距离
 */
public class Problem1855 {

    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int max = 0;
            int n1 = nums1.length;
            int n2 = nums2.length;
            int i = n1 - 1, j = n2 - 1;
            for (; j >= 0; j--) {
                int jNum = nums2[j];
                i = Math.min(i, j);
                for (; i >= 0; i--) {
                    int iNum = nums1[i];
                    if (iNum <= jNum) {
                        max = Math.max(max, j - i);
                    } else {
                        break;
                    }
                }
            }

            return max;
        }
    }

}