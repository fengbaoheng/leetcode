/*
 * @lc app=leetcode.cn id=1415 lang=java
 *
 * [1415] 长度为 n 的开心字符串中字典序第 k 小的字符串
 */

// @lc code=start
class Solution {
    int count;
    int k;
    int n;
    String result = "";

    public String getHappyString(int n, int k) {
        this.count = 0;
        this.k = k;
        this.n = n;
        track(0, new char[n]);
        return result;
    }

    private void track(int index, char[] arr) {
        if (count >= k) {
            return;
        }

        if (index == n) {
            count++;
            if (count == k) {
                result = new String(arr);
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            char ch = (char) ('a' + i);

            if (index != 0 && arr[index - 1] == ch) {
                continue;
            }
            arr[index] = ch;
            track(index + 1, arr);
        }
    }
}
// @lc code=end

