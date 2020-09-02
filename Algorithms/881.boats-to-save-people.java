/*
 * @lc app=leetcode.cn id=881 lang=java
 *
 * [881] 救生艇
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int p = 0, q = people.length - 1;
        int count = 0;

        while (p <= q) {
            if (p == q) {
                count++;
                break;
            }

            if (people[p] + people[q] <= limit) {
                p++;
            }

            q--;
            count++;
        }

        return count;
    }
}
// @lc code=end

