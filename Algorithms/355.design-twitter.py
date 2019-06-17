#
# @lc app=leetcode.cn id=355 lang=python3
#
# [355] 设计推特
#
import unittest
from typing import List, Dict, Tuple, Set
import heapq


class User:
    def __init__(self, id):
        self.id = id

        # tweet: (id, time)
        self.tweets: List[Tuple[int, int]] = []
        self.follows: Set[int] = set([])

    def last_ten_tweet(self):
        return self.tweets[-10:]


class Twitter:
    def __init__(self):
        self.clock = 1000
        self.users: Dict[int, User] = {}

    def postTweet(self, userId: int, tweetId: int) -> None:
        tweet = (tweetId, self.clock)
        self.clock += 1

        if userId not in self.users:
            self.users[userId] = User(userId)

        self.users[userId].tweets.append(tweet)

    def getNewsFeed(self, userId: int) -> List[int]:
        if userId not in self.users:
            self.users[userId] = User(userId)

        cur_user = self.users[userId]

        all_tweets = cur_user.tweets[:]
        for follow_id in cur_user.follows:
            all_tweets.extend(self.users[follow_id].last_ten_tweet())

        if len(all_tweets) <= 10:
            last_ten = sorted(all_tweets, key=lambda x: x[1], reverse=True)
        else:
            last_ten = heapq.nlargest(10, all_tweets, lambda t: t[1])
        return list(map(lambda t: t[0], last_ten))

    def follow(self, followerId: int, followeeId: int) -> None:
        if followeeId == followerId:
            return
        if followerId not in self.users:
            self.users[followerId] = User(followerId)
        if followeeId not in self.users:
            self.users[followeeId] = User(followeeId)

        self.users[followerId].follows.add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.users:
            return

        follower = self.users[followerId]

        if followeeId not in self.users or followeeId not in follower.follows:
            return

        follower.follows.remove(followeeId)


class TestTwiteer(unittest.TestCase):
    def setUp(self):
        self.twitter = Twitter()

    def test_empty(self):
        self.assertListEqual(self.twitter.getNewsFeed(1), [])
        self.assertListEqual(self.twitter.getNewsFeed(2), [])
        self.assertListEqual(self.twitter.getNewsFeed(-1), [])

    def test_user_without_follow(self):
        self.assertListEqual(self.twitter.getNewsFeed(1), [])

        self.twitter.postTweet(1, 10)
        self.assertListEqual(self.twitter.getNewsFeed(1), [10])

        self.twitter.postTweet(1, 11)
        self.twitter.postTweet(1, 12)
        self.assertListEqual(self.twitter.getNewsFeed(1), [12, 11, 10])

    def test_over_ten_without_follow(self):
        self.assertListEqual(self.twitter.getNewsFeed(1), [])

        self.twitter.postTweet(1, 11)
        self.twitter.postTweet(1, 12)
        self.twitter.postTweet(1, 13)
        self.twitter.postTweet(1, 14)
        self.twitter.postTweet(1, 15)
        self.twitter.postTweet(1, 16)
        self.twitter.postTweet(1, 17)
        self.twitter.postTweet(1, 18)
        self.twitter.postTweet(1, 19)
        self.twitter.postTweet(1, 20)
        self.twitter.postTweet(2, 33)
        self.twitter.postTweet(1, 21)

        self.assertListEqual(
            self.twitter.getNewsFeed(1), [21, 20, 19, 18, 17, 16, 15, 14, 13, 12]
        )

    def test_user_with_follow(self):
        self.assertListEqual(self.twitter.getNewsFeed(1), [])
        self.assertListEqual(self.twitter.getNewsFeed(2), [])

        self.twitter.postTweet(1, 11)
        self.assertListEqual(self.twitter.getNewsFeed(1), [11])
        self.assertListEqual(self.twitter.getNewsFeed(2), [])

        self.twitter.postTweet(2, 21)
        self.assertListEqual(self.twitter.getNewsFeed(1), [11])
        self.assertListEqual(self.twitter.getNewsFeed(2), [21])

        self.twitter.follow(1, 2)
        self.assertListEqual(self.twitter.getNewsFeed(1), [21, 11])

        self.twitter.postTweet(2, 22)
        self.assertListEqual(self.twitter.getNewsFeed(1), [22, 21, 11])

        self.twitter.unfollow(1, 2)
        self.assertListEqual(self.twitter.getNewsFeed(1), [11])

        self.twitter.postTweet(2, 23)
        self.twitter.follow(1, 2)
        self.assertListEqual(self.twitter.getNewsFeed(1), [23, 22, 21, 11])


if __name__ == "__main__":

    unittest.main()
