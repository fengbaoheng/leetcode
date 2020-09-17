/*
 * @lc app=leetcode.cn id=787 lang=java
 *
 * [787] K 站中转内最便宜的航班
 */

// @lc code=start
import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Airport[] airports = new Airport[n];
        for (int i = 0; i < n; i++) {
            airports[i] = new Airport(K);
        }

        for (int[] flight : flights) {
            Airport source = airports[flight[0]];
            Airport target = airports[flight[1]];
            source.addNeighbor(target, flight[2]);
        }

        for (int k = 1; k <= K; k++) {
            for (Airport airport : airports) {
                airport.updateCheapestPrice(airports, k);
            }
        }

        Airport source = airports[src];
        Airport target = airports[dst];
        int price = source.getPrice(target, K);
        return price == Airport.INFINITY ? -1 : price;
    }
}

// 机场
class Airport {
    // 不可达的费用
    public static final int INFINITY = 1000000000;

    private final int K;
    private final List<Airport> directs = new LinkedList<>();
    private final Map<Airport, int[]> priceMap = new HashMap<>();

    public Airport(int k) {
        K = k;
    }

    public void addNeighbor(Airport target, int price) {
        directs.add(target);

        int[] prices = new int[K + 1];
        Arrays.fill(prices, INFINITY);
        prices[0] = price;
        priceMap.put(target, prices);
    }

    public void updateCheapestPrice(Airport[] airports, int k) {
        if (k <= 0) {
            return;
        }

        // 对每个站都更新, 即使当前还不可达
        for (Airport target : airports) {
            // 当前的最小费用
            int minPrice = getPrice(target, k - 1);

            // 对每个可能的中转站进行中转
            for (Airport transfer : directs) {
                if (transfer == target) {
                    continue;
                }

                // 先到达中转站, 一定可达
                int priceSourceToTransfer = this.getPrice(transfer, 0);

                // 肯定无法获得更低的价格
                if (priceSourceToTransfer >= minPrice) {
                    continue;
                }

                // 从中转站到达目标站
                int priceTransferToTarget = transfer.getPrice(target, k - 1);

                minPrice = Math.min(minPrice, priceSourceToTransfer + priceTransferToTarget);
            }

            if (minPrice < INFINITY) {
                setPrice(target, k, minPrice);
            }
        }


    }

    private void setPrice(Airport target, int k, int price) {
        if (priceMap.containsKey(target)) {
            priceMap.get(target)[k] = price;
        } else {
            int[] prices = new int[K + 1];
            Arrays.fill(prices, INFINITY);
            prices[k] = price;
            priceMap.put(target, prices);
        }
    }

    public int getPrice(Airport target, int k) {
        if (priceMap.containsKey(target)) {
            return priceMap.get(target)[k];
        } else {
            return INFINITY;
        }
    }
}

// @lc code=end

