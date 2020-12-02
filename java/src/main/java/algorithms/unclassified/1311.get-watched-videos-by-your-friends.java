/*
 * @lc app=leetcode.cn id=1311 lang=java
 *
 * [1311] 获取你好友已观看的视频
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Person.clear();
        Video.clear();
        
        int n = friends.length;

        for (int i = 0; i < n; i++) {
            Person.add(i, watchedVideos.get(i), friends[i]);
        }

        Set<Person> searched = new HashSet<>();
        Set<Person> curLevel = new HashSet<>();
        Set<Person> nextLevel = new HashSet<>();

        curLevel.add(Person.get(id));

        while (level > 0) {
            searched.addAll(curLevel);

            for (Person cur : curLevel) {
                for (Person next : cur.getFriends()) {
                    if (!searched.contains(next)) {
                        nextLevel.add(next);
                    }
                }
            }

            curLevel.clear();
            curLevel.addAll(nextLevel);
            nextLevel.clear();

            level--;
        }


        Set<Video> videos = new HashSet<>();
        for (Person person : curLevel) {
            for (Video video : person.getWatchedVideos()) {
                video.increaseCount();
                videos.add(video);
            }
        }

        return videos.stream().
                sorted().map(Video::getName)
                .collect(Collectors.toList());
    }
}

class Person {
    private static Map<Integer, Person> MAP = new HashMap<>();
    private Set<Video> watchedVideos = new HashSet<>();
    private Set<Person> friends = new HashSet<>();

    public static void add(int id, List<String> watchedVideos, int[] friends) {
        MAP.putIfAbsent(id, new Person());
        Person person = MAP.get(id);

        person.watchedVideos.addAll(Video.get(watchedVideos));
        person.friends.addAll(Person.get(friends));
    }

    public static Person get(int id) {
        MAP.putIfAbsent(id, new Person());
        return MAP.get(id);
    }

    public static List<Person> get(int[] friends) {
        return IntStream.of(friends)
                .mapToObj(Person::get)
                .collect(Collectors.toList());
    }
    
    public static void clear(){
        MAP.clear();
    }

    public Set<Video> getWatchedVideos() {
        return watchedVideos;
    }

    public Set<Person> getFriends() {
        return friends;
    }
}


class Video implements Comparable<Video> {
    private static Map<String, Video> MAP = new HashMap<>();

    private String name;
    private int count;

    private Video(String name) {
        this.name = name;
    }

    public static void clear(){
        MAP.clear();
    }

    public static Video add(String name) {
        MAP.putIfAbsent(name, new Video(name));
        return MAP.get(name);
    }

    public static List<Video> get(List<String> names) {
        return names.stream().map(Video::add).collect(Collectors.toList());
    }

    public void increaseCount() {
        this.count++;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Video o) {
        int cmpCount = Integer.compare(count, o.count);
        return cmpCount != 0 ? cmpCount : name.compareTo(o.name);
    }
}
// @lc code=end

