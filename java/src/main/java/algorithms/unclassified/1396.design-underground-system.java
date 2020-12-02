import java.util.*;

/*
 * @lc app=leetcode.cn id=1396 lang=java
 *
 * [1396] 设计地铁系统
 */

// @lc code=start
class UndergroundSystem {

    /**
     * 记录车站
     */
    private Map<String, Station> stations = new HashMap<>();

    /**
     * 记录乘客
     */
    private Map<Integer, Passenger> passengers = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        passengers.put(id, new Passenger(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Passenger passenger = passengers.get(id);

        Station source = getStation(passenger.source);
        Station target = getStation(stationName);

        source.record(target, t - passenger.checkIn);
    }

    public double getAverageTime(String startStation, String endStation) {
        return stations.get(startStation).getAverage(stations.get(endStation));
    }

    private Station getStation(String name) {
        Station station = stations.get(name);
        if (station == null) {
            station = new Station();
            stations.put(name, station);
        }
        return station;
    }
}

class Passenger {
    String source;
    int checkIn;

    public Passenger(String source, int checkIn) {
        this.source = source;
        this.checkIn = checkIn;
    }
}

class Station {
    private final Map<Station, Trip> trips = new HashMap<>();

    public void record(Station target, int time) {
        if (!trips.containsKey(target)) {
            trips.put(target, new Trip());
        }

        trips.get(target).record(time);
    }

    public double getAverage(Station station) {
        return trips.get(station).getAverage();
    }
}

class Trip {
    private long sumTime;
    private int count;

    /**
     * 添加旅程时间记录
     */
    public void record(int time) {
        sumTime += time;
        count++;
    }

    /**
     * @return 获取旅程平均时间
     */
    public double getAverage() {
        return count == 0 ? 0 : sumTime / (double) count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double param_3
 * = obj.getAverageTime(startStation,endStation);
 */
// @lc code=end
