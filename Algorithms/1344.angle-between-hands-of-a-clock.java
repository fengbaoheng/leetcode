/*
 * @lc app=leetcode.cn id=1344 lang=java
 *
 * [1344] 时钟指针的夹角
 */

// @lc code=start
class Solution {
    /**
     * 分针每分钟走6度
     */
    private static final int ANGLE_PER_MINUTE = 6;

    /**
     * 时针每小时走30度
     */
    private static final int ANGLE_PER_HOUR = 30;

    
    public double angleClock(int hour, int minutes) {
        return getDiff(getHourAngle(hour, minutes), getMinutesAngle(minutes));
    }

    /**
     * 
     * @param hour    小时
     * @param minutes 分钟
     * @return 时针角度
     */
    private double getHourAngle(int hour, int minutes) {
        return ANGLE_PER_HOUR * (hour + minutes / 60.0);
    }

    /**
     * 
     * @param minutes 分钟
     * @return 分针角度
     */
    private int getMinutesAngle(int minutes) {
        return ANGLE_PER_MINUTE * minutes;
    }

    /**
     * 
     * @param angle1 角度1
     * @param angle2 角度2
     * @return 角度差值
     */
    private double getDiff(double angle1, double angle2) {
        angle1 %= 360;
        angle2 %= 360;
        double diff = (360 + angle1 - angle2) % 360;

        return diff > 180 ? 360 - diff : diff;
    }
}
// @lc code=end
