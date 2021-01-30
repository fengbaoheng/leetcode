package algorithms;

/**
 * 1725.可以形成最大正方形的矩形数目
 */
class NumberOfRectanglesThatCanFormTheLargestSquare {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int count = 0;

        for (int[] rectangle : rectangles) {
            int w = rectangle[0];
            int h = rectangle[1];

            // 无法达到正方形边长
            if (w < maxLen || h < maxLen) {
                continue;
            }

            // 可以切成更大的正方形
            if (w > maxLen && h > maxLen) {
                maxLen = Math.min(w, h);
                count = 1;
                continue;
            }

            // 能够切成同样的正方形
            count++;
        }

        return count;
    }
}

