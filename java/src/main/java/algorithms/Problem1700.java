package algorithms;

/**
 * 1700.无法吃午餐的学生数量
 */
class Problem1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length;

        // 统计喜欢两种类型的学生人数
        int[] like = new int[len];
        for (int student : students) {
            like[student]++;
        }

        // 依次遍历顶部的三明治
        for (int sandwich : sandwiches) {
            if (like[sandwich] > 0) {
                // 只要顶部的三明治还有人吃，就一定可以被取走（最坏情况下循环一轮）
                like[sandwich]--;
            } else {
                // 顶部的三明治没有任何人喜欢，永远不会被拿走，因此可以直接退出循环
                break;
            }
        }

        return like[0] + like[1];
    }
}
