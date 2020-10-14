/*
 * @lc app=leetcode.cn id=726 lang=java
 *
 * [726] 原子的数量
 */

// @lc code=start
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public String countOfAtoms(String formula) {
        return parse(formula, 0, formula.length()).countOfAtoms();
    }

    // 解析部分表达式
    private Formula parse(String s, int start, int end) {
        Formula formula = new Formula();

        int j;
        for (int i = start; i < end; i = j) {
            char ch = s.charAt(i);
            j = i + 1;
            Formula nextFormula;

            if (Character.isUpperCase(ch)) {
                // 以大写字母开头的化学式
                // 解析小写字母
                StringBuilder atom = new StringBuilder();
                atom.append(ch);
                while (j < end && Character.isLowerCase(s.charAt(j))) {
                    atom.append(s.charAt(j));
                    j++;
                }

                // 解析数字
                int count = 0;
                while (j < end && Character.isDigit(s.charAt(j))) {
                    count = count * 10 + (s.charAt(j) - '0');
                    j++;
                }
                count = Math.max(1, count);

                nextFormula = new Formula(atom.toString(), count);
            } else {

                // 找到括号包裹的范围
                int bracketsCount = 1;
                for (; j < end && bracketsCount > 0; j++) {
                    char c = s.charAt(j);
                    if (c == '(') {
                        bracketsCount++;
                    } else if (c == ')') {
                        bracketsCount--;
                    }
                }

                // 递归解析括号内部的公式
                Formula inner = parse(s, i + 1, j - 1);

                // 解析括号后面的数字
                int count = 0;
                while (j < end && Character.isDigit(s.charAt(j))) {
                    count = count * 10 + (s.charAt(j) - '0');
                    j++;
                }
                count = Math.max(1, count);

                nextFormula = new Formula(inner, count);
            }

            formula.add(nextFormula);
        }

        return formula;
    }
}

// 嵌套公式类
class Formula {
    // 单原子公式
    private String atom;

    // 内部嵌套的公式
    private final List<Formula> inners = new LinkedList<>();

    private int count = 1;

    public Formula() {
    }

    public Formula(Formula inner, int count) {
        inners.add(inner);
        this.count = count;
    }

    public Formula(String atom, int count) {
        this.atom = atom;
        this.count = count;
    }

    public void add(Formula formula) {
        inners.add(formula);
    }

    // 统计原子数目
    private Map<String, Integer> getAtoms() {
        Map<String, Integer> map = new HashMap<>();

        if (atom != null) {
            map.put(atom, count);
            return map;
        }

        for (Formula inner : inners) {
            for (Map.Entry<String, Integer> entry : inner.getAtoms().entrySet()) {
                String innerAtom = entry.getKey();
                Integer innerCount = entry.getValue();
                map.merge(innerAtom, innerCount * count, Integer::sum);
            }
        }

        return map;
    }

    public String countOfAtoms() {
        StringBuilder builder = new StringBuilder();

        Map<String, Integer> atoms = getAtoms();
        atoms.keySet().stream().sorted().forEach(name -> {
            int count = atoms.get(name);
            builder.append(name);
            if (count > 1) {
                builder.append(count);
            }
        });

        return builder.toString();
    }
}
// @lc code=end

