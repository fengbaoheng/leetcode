/*
 * @lc app=leetcode.cn id=16 lang=csharp
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (39.06%)
 * Total Accepted:    17.5K
 * Total Submissions: 44.8K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
public class Solution
{
    public int ThreeSumClosest(int[] nums, int target)
    {
        // 去除边界情况
        if (nums.Length < 3) { return 0; }
        else if (nums.Length == 3) { return nums.Sum(); }

        // 去除重复超过3次的数字
        var list = new List<int>();
        var dict = new Dictionary<int, int>();
        foreach (var num in nums)
        {
            if (!dict.ContainsKey(num))
            {
                dict[num] = 0;
            }
            if (dict[num] < 3)
            {
                dict[num] += 1;
                list.Add(num);
            }
        }

        // 排序
        list.Sort();
        var closest = int.MaxValue;
        var minDiff = int.MaxValue;
        for (int i = 0; i < list.Count; i++)
        {
            // 双指针查找
            var s = i + 1;
            var e = list.Count - 1;

            while (s < e)
            {
                var d = target - (list[s] + list[e] + list[i]);
                var dAbs = Math.Abs(d); // 和目标值的差距
                if (dAbs < minDiff)
                {
                    minDiff = dAbs;
                    closest = target - d;

                    if (minDiff == 0) { return closest; }
                }

                if (d < 0) { e--; }
                else { s++; }
            }
        }
        return closest;
    }
}

