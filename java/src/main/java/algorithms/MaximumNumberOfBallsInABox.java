package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 1742.盒子中小球的最大数量
 */

class MaximumNumberOfBallsInABox {
    public int countBalls(int lowLimit, int highLimit) {
        final int n = highLimit - lowLimit + 1;
        Map<Integer, Integer> boxMap = new HashMap<>(n);

        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0;

            // 计算盒子编号
            int ball = i;
            while (ball != 0) {
                box += ball % 10;
                ball /= 10;
            }

            // 盒子中球的数量+1
            boxMap.merge(box, 1, Integer::sum);
        }

        return boxMap.values().stream().mapToInt(Integer::intValue).max().orElse(0);
    }
}
