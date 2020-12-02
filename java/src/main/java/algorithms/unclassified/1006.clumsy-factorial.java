/*
 * @lc app=leetcode.cn id=1006 lang=java
 *
 * [1006] 笨阶乘
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
    private enum Operator {
        MUL("*"), DIV("/"), ADD("+"), SUB("-");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    private static final Operator[] operators = {
            Operator.MUL,
            Operator.DIV,
            Operator.ADD,
            Operator.SUB
    };

    public int clumsy(int N) {
        List<Num> nums = new ArrayList<>();
        nums.add(new Num(N, Operator.ADD));

        int index = 0;
        for (int i = N - 1; i > 0; i--) {
            Num num = new Num(i, operators[index++]);
            index %= 4;

            if (num.isHighPriority()) {
                nums.get(nums.size() - 1).calculate(num);
            } else {
                nums.add(num);
            }
        }

        Num result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result.calculate(nums.get(i));
        }
        return result.getVal();
    }


    private static class Num {
        private final Operator operator;
        private int val;

        public Num(int val, Operator operator) {
            this.val = val;
            this.operator = operator;
        }

        private boolean isHighPriority() {
            return operator == Operator.MUL || operator == Operator.DIV;
        }

        public void calculate(Num num) {
            switch (num.operator) {
                case MUL:
                    val *= num.val;
                    break;
                case DIV:
                    val /= num.val;
                    break;
                case ADD:
                    val += num.val;
                    break;
                case SUB:
                    val -= num.val;
                    break;
            }
        }

        public int getVal() {
            return val;
        }

        @Override
        public String toString() {
            return String.format("%s %d", operator, val);
        }
    }
}
// @lc code=end

