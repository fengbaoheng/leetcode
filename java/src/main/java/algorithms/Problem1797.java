package algorithms;

import java.util.*;

/**
 * 1797.设计一个验证系统
 */
public class Problem1797 {
    static class AuthenticationManager {
        private static final int CAPACITY = 2000;
        private final int timeToLive;

        private final LinkedHashMap<String, Integer> tokenMap = new LinkedHashMap<>(CAPACITY);

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            tokenMap.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            clearExpired(currentTime);
            Integer oldTime = tokenMap.remove(tokenId);
            if (oldTime == null) {
                return;
            }
            tokenMap.put(tokenId, currentTime + timeToLive);
        }

        public int countUnexpiredTokens(int currentTime) {
            clearExpired(currentTime);
            return tokenMap.size();
        }

        // 清除过期对象 保证只存在未过期的对象
        private void clearExpired(int currentTime) {
            Set<String> toRemove = new HashSet<>();
            for (Map.Entry<String, Integer> entry : tokenMap.entrySet()) {
                if (entry.getValue() <= currentTime) {
                    toRemove.add(entry.getKey());
                } else {
                    break;
                }
            }

            toRemove.forEach(tokenMap::remove);
        }
    }
}