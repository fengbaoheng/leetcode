/*
 * @lc app=leetcode.cn id=1169 lang=java
 *
 * [1169] 查询无效交易
 */

// @lc code=start
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        final TransactionRecord record = new TransactionRecord();

        // 创建交易对象
        Arrays.stream(transactions).map(Transaction::new).forEach(record::add);

        // 过滤非法交易
        record.searchInvalids();

        // 返回非法交易
        return record.invalids.stream().map(Transaction::toString).collect(Collectors.toList());
    }
}

class Transaction {
    private final String description; // 原始描述
    final String id;
    final int time;
    final int count;
    final String city;

    Transaction(String description) {
        this.description = description;

        String[] fields = description.split(",");
        id = fields[0];
        time = Integer.parseInt(fields[1]);
        count = Integer.parseInt(fields[2]);
        city = fields[3];
    }

    @Override
    public String toString() {
        return description;
    }
}

class TransactionRecord {
    // 记录非法交易
    Set<Transaction> invalids = new HashSet<>();

    // 记录所有交易
    private Map<String, List<Transaction>> map = new HashMap<>();

    // 将交易对象添加进map中
    void add(Transaction transaction) {
        String key = transaction.id;
        List<Transaction> transactions = map.getOrDefault(key, new ArrayList<>());
        transactions.add(transaction);
        map.put(key, transactions);
    }

    // 搜索无效的交易
    void searchInvalids() {
        Set<String> idSet = map.keySet();
        for (String id : idSet) {
            List<Transaction> transactions = map.get(id);

            // 按时间排序 可减少内层循环次数
            transactions.sort(Comparator.comparing(t -> t.time));

            for (int i = 0; i < transactions.size(); i++) {
                Transaction cur = transactions.get(i);

                // 超过1000必定无效
                if (cur.count > 1000) {
                    invalids.add(cur);
                }

                // 内循环依次判断是否有效
                for (int j = i; j < transactions.size(); j++) {
                    Transaction next = transactions.get(j);
                    int timeInterval = next.time - cur.time;

                    // 当时间间隔超过了60分钟后即可跳出循环, 因为已按时间排序
                    if (timeInterval > 60) {
                        break;
                    }

                    // 两个都为无效交易
                    if (!next.city.equals(cur.city)) {
                        invalids.add(cur);
                        invalids.add(next);
                    }
                }
            }
        }
    }
}
// @lc code=end
