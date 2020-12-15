package algorithms;

/**
 * 1688.比赛中的配对次数
 *
 */
class CountOfMatchesInTournament {
    public int numberOfMatches(int n) {
        int count = 0;

        while (n > 1) {
            count += n / 2;
            n = (n >> 1) + (n & 1);
        }

        return count;
    }
}
