/*
 * @lc app=leetcode.cn id=1604 lang=java
 *
 * [1604] 警告一小时内使用相同员工卡大于等于三次的人
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, User> users = createUsers(keyName, keyTime);

        return users.values()
                .stream()
                .filter(User::checkAlert)
                .map(User::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private Map<String, User> createUsers(String[] keyName, String[] keyTime) {
        Map<String, User> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            User user = map.computeIfAbsent(keyName[i], User::new);
            user.addTime(keyTime[i]);
        }
        return map;
    }
}

// 记录用户和刷卡时间
class User {
    private final String name;
    private final List<Integer> times = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    // 检查是否会被警告
    public boolean checkAlert() {
        // 刷卡时间排序
        Collections.sort(times);
        // 最近三次是否在同一小时
        for (int i = 0; i < times.size() - 2; i++) {
            int cur = times.get(i);
            int future = times.get(i + 2);
            if (future - cur <= 60) {
                return true;
            }
        }
        return false;
    }


    public void addTime(String strTime) {
        String hour = strTime.substring(0, 2);
        String minute = strTime.substring(3);
        int time = 60 * Integer.parseInt(hour) + Integer.parseInt(minute);
        times.add(time);
    }

    public String getName() {
        return name;
    }
}
// @lc code=end

