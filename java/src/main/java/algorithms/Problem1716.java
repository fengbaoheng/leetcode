package algorithms;

/**
 * 1716.计算力扣银行的钱
 */
class Problem1716 {
    public int totalMoney(int n) {
        int total = 0;
        int money = 1;
        for (int day = 1; day <= n; day++) {
            total += money;

            if (day % 7 == 0) {
                money -= 5;
            } else {
                money++;
            }
        }
        return total;
    }
}

