/*
 * @lc app=leetcode.cn id=15 lang=csharp
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (20.97%)
 * Total Accepted:    38.3K
 * Total Submissions: 182.2K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
public class Solution
{
    /// <summary>
    /// 三个数求和为0
    /// 暴力方法: 找到所有三个数字的组合, 过滤去重.O(n3)
    /// 双指针法: nums[i] = nums[j] + num[k], 使用O(n)的双指针找j和k, 最终O(n2)
    /// </summary>
    /// <param name="nums"></param>
    /// <returns></returns>
    public IList<IList<int>> ThreeSum(int[] nums)
    {
        var list = new List<int>(nums);
        var dict = new Dictionary<string, IList<int>>();

        // 1. 先排序
        list.Sort();

        // 去重
        var newList = new List<int>();
            for (int i = 0; i < list.Count; i++)
            {
                var cur = list[i];

                if(newList.Count <3)
                {
                    newList.Add(cur);
                    continue;
                }

                var last = newList[newList.Count - 1];
                var last2 = newList[newList.Count - 2];
                var last3 = newList[newList.Count - 3];

                if (last3 == last2 && last2 == last && last == cur)
                {
                    continue;
                }

                newList.Add(cur);
            }

        list = newList;

        // 2. 寻找上下限
        while (list.Count >= 3 && (list[0] + list[list.Count - 1] + list[list.Count - 2]) < 0)
        {
            list.RemoveAt(0);
        }

        while (list.Count >= 3 && list[0] + list[1] + list[list.Count - 1] > 0)
        {
            list.RemoveAt(list.Count - 1);
        }

        // 3. 循环对每个数使用双指针
        var length = list.Count;
        for (int i = 0; i < length; i++)
        {
            // 定义头尾指针
            var s = 0;
            var e = length - 1;

            while (s < e)
            {
                if (s == i)
                {
                    s++;
                    continue;
                }
                else if (e == i)
                {
                    e--;
                    continue;
                }

                var add = list[s] + list[e] + list[i];
                if (add == 0)
                {
                    var result = new List<int> { list[i], list[s], list[e] };
                    result.Sort();
                    var str = string.Join(",", result);
                    if (!dict.ContainsKey(str))
                    {
                        dict[str] = result;
                    }

                    s++;
                }
                else if (add < 0)
                {
                    s++;
                    while (s < length - 1 && list[s] == list[s - 1])
                    {
                        s++;
                    }
                }
                else
                {
                    e--;
                    while (e > 0 && list[e] == list[e + 1])
                    {
                        e--;
                    }
                }
            }
        }

        return dict.Values.ToList();
    }
}
