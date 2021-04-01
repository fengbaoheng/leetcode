package algorithms;

/**
 * 1732.找到最高海拔
 */

class Problem1732 {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int altitude = 0;

        for (int diff : gain) {
            altitude += diff;
            highest = Math.max(highest, altitude);
        }

        return highest;
    }
}

