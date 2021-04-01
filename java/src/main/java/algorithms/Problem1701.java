package algorithms;

/**
 * 1701.平均等待时间
 */
class Problem1701 {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;

        long time = 0;
        int previousFinishTime = -1;

        for (int[] customer : customers) {
            int arriveTime = customer[0];
            int orderTime = customer[1];
            int waitTime = handle(previousFinishTime, arriveTime, orderTime);

            time += waitTime;
            previousFinishTime = arriveTime + waitTime;
        }

        return (double) time / n;
    }

    /**
     * 计算等待时间
     *
     * @param previousFinishTime 前一顾客完成时间
     * @param arriveTime         当前顾客到达时间
     * @param orderTime          当前顾客订单所需时间
     * @return 当前顾客需要等待的时间
     */
    private int handle(int previousFinishTime, int arriveTime, int orderTime) {
        // 不需等待前一顾客完成
        if (arriveTime >= previousFinishTime) {
            return orderTime;
        }
        return orderTime + (previousFinishTime - arriveTime);
    }
}
