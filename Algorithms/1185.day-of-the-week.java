/*
 * @lc app=leetcode.cn id=1185 lang=java
 *
 * [1185] 一周中的第几天
 */


import java.util.*;

class Solution {
    private static final String[] WEEK_DAY = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    // 直接调用日历API
    public String dayOfTheWeek(int day, int month, int year) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day);

        calendar.get(Calendar.DAY_OF_WEEK);

        int index = calendar.get(Calendar.DAY_OF_WEEK);
        return WEEK_DAY[index-1];
    }
}