/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */
class Solution {
    // 同时计算正反路线长度, 比较取最小即可
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int o = Math.min(start, destination);
        int d = Math.max(start, destination);

        int length = distance.length;

        int total = 0;
        int odDistance = 0;

        for (int i = 0; i < length; i++) {
            int value = distance[i];

            total += value;
            if(i>=o && i < d){
                odDistance += value;
            }
        }

        int doDistance = total - odDistance;

        return Math.min(odDistance, doDistance);
    }
}

