/*
 * @lc app=leetcode.cn id=981 lang=java
 *
 * [981] 基于时间的键值存储
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    Map<String, Entry> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).set(timestamp, value);
        } else {
            map.put(key, new Entry(timestamp, value));
        }
    }

    public String get(String key, int timestamp) {
        Entry entry = map.get(key);
        if (entry == null) {
            return "";
        }

        return entry.get(timestamp);
    }

    private static class Entry {
        private TreeMap<Integer, String> map = new TreeMap<>();

        public Entry(int timestamp, String value) {
            set(timestamp, value);
        }

        public void set(int timestamp, String value) {
            map.put(timestamp, value);
        }

        public String get(int timestamp) {
            if (map.containsKey(timestamp)) {
                return map.get(timestamp);
            } else {
                Integer lowerKey = map.lowerKey(timestamp);
                if (lowerKey == null) {
                    return "";
                }
                return map.get(lowerKey);
            }
        }
    }
}
// @lc code=end

