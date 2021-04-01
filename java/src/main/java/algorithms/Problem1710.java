package algorithms;

/**
 * 1710.卡车上的最大单元数
 */
class Problem1710 {
    private final int N = 1000 + 1;

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] unitCountArray = new int[N];

        for (int[] box : boxTypes) {
            int count = box[0];
            int unit = box[1];
            unitCountArray[unit] += count;
        }

        int sumUnit = 0;
        for (int unit = N - 1; unit >= 0; unit--) {
            int count = unitCountArray[unit];

            // 不存在箱子
            if (count == 0) {
                continue;
            }

            // 是否能否装下所有箱子
            if (count <= truckSize) {
                sumUnit += count * unit;
                truckSize -= count;
            } else {
                // 装满即可
                sumUnit += truckSize * unit;
                break;
            }

        }

        return sumUnit;
    }
}