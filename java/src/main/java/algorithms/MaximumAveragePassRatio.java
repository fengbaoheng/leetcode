package algorithms;

import java.util.*;

/**
 * 1792.最大平均通过率
 */
class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        final int n = classes.length;

        // 按照value最大排序
        Queue<AClass> queue = new PriorityQueue<>(n, Comparator.comparingDouble(c -> -c.value));

        for (int[] aClass : classes) {
            if (aClass[0] != aClass[1]) {
                queue.offer(new AClass(aClass));
            }
        }

        // 贪心，不断找出value最大的班级，填充学生
        if (!queue.isEmpty()) {
            while (extraStudents > 0) {
                AClass aClass = queue.poll();
                extraStudents--;
                aClass.increase();
                queue.offer(aClass);
            }
        }

        // 计算结果返回
        double ratio = 0;
        for (int[] aClass : classes) {
            ratio += (double) aClass[0] / aClass[1];
        }

        return ratio / n;
    }

    private static final class AClass {
        private final int[] array;
        private double value;

        public AClass(int[] array) {
            this.array = array;
            this.value = calcValue();
        }

        private void increase() {
            array[0]++;
            array[1]++;
            value = calcValue();
        }

        // 计算填充一个学生后，通过率变化量
        private double calcValue() {
            return (array[1] - array[0]) / ((double) array[1] * array[1] + array[1]);
        }
    }
}
