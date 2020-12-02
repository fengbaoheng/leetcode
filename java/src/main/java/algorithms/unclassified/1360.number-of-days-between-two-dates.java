/*
 * @lc app=leetcode.cn id=1360 lang=java
 *
 * [1360] 日期之间隔几天
 */

// @lc code=start
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int days1 = new Date(date1).daysTo1971();
        int days2 = new Date(date2).daysTo1971();
        return Math.abs(days1 - days2);
    }
}

/**
 * 日期类
 */
class Date {
    private static int[][] MONTH_DAYS = new int[][]{
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
    };

    private final int year;
    private final int month;
    private final int day;

    public Date(String date) {
        year = Integer.parseInt(date, 0, 4, 10);
        month = Integer.parseInt(date, 5, 7, 10);
        day = Integer.parseInt(date, 8, 10, 10);
    }

    /**
     * @return 距离1971年的天数
     */
    public int daysTo1971() {
        int days = 0;

        // 逐年累加
        for (int y = 1971; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }

        // 逐月累加
        int[] monthDays = isLeapYear(year) ? MONTH_DAYS[1] : MONTH_DAYS[0];
        for (int m = 0; m < month - 1; m++) {
            days += monthDays[m];
        }

        // 累加日
        days += day;

        return days;
    }


    /**
     * @param year 年份
     * @return 判断是否为闰年
     */
    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
// @lc code=end

