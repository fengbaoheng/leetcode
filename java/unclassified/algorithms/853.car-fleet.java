/*
 * @lc app=leetcode.cn id=853 lang=java
 *
 * [853] 车队
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int count = position.length;

        // 初始化车辆
        List<Car> cars = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            cars.add(new Car(target, position[i], speed[i]));
        }

        // 按车辆位置倒序排列
        cars.sort(Comparator.comparingInt(Car::getPosition).reversed());

        // 依次尝试编队
        List<Fleet> fleets = new ArrayList<>();
        for (Car car : cars) {
            if (fleets.isEmpty()) {
                // 单独车辆编队
                fleets.add(new Fleet(car));
            } else {
                // 最近的车队
                Fleet fleet = fleets.get(fleets.size() - 1);
                // 判断是否能够加入该车队
                // 若不能则新建一个车队
                if (!fleet.canJoin(car)) {
                    fleets.add(new Fleet(car));
                }
            }
        }

        return fleets.size();
    }
}

class Car {
    // 车辆位置
    private int position;

    // 车辆到达终点的理论用时
    private double time;

    public Car(int target, int position, int speed) {
        this.position = position;
        this.time = (double) (target - position) / speed;
    }

    public int getPosition() {
        return position;
    }

    public double getTime() {
        return time;
    }
}

class Fleet {
    // 整个车队最快到达终点的时间
    private double time;

    // 头车的速度决定了车队速度
    // 因为无法超车
    public Fleet(Car car) {
        this.time = car.getTime();
    }

    // 给定车辆， 判断是否能够在到达终点前加入该车队
    boolean canJoin(Car car) {
        return car.getTime() <= time;
    }
}
// @lc code=end

