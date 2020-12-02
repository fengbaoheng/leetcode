/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // 记录letters中存在的字母
        int[] flag = new int[26];
        for (char letter : letters) {
            flag[letter - 'a'] = 1;
        }

        // i从target+1开始, 遍历flag查找flag[i]==1
        int index = target - 'a' + 1;
        for (int i = index; i < index + 26; i++) {
            int j = i % 26;
            if (flag[j] == 1) {
                return (char) (j + 'a');
            }
        }

        return ' ';
    }
}
