package D.DesignTwitter_355;

import java.util.*;

/**
 * $$ Assume n is the number of users that a user follows.
 * $$ Constructor Time Complexity: O(1)
 * $$ postTweet() Time Complexity: O(1)
 * $$ getNewsFeed() Time Complexity: O(n)
 * $$ follow() Time Complexity: O(1)
 * $$ unfollow() Time Complexity: O(1)
 */
class Twitter1 {
    private final Map<Integer, Set<Integer>> follows = new HashMap<>();
    private final Map<Integer, List<int[]>> tweets = new HashMap<>();
    private int time = 0;

    public Twitter1() {

    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time});
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followings = follows.getOrDefault(userId, new HashSet<>());
        followings.add(userId);
        List<Integer> res = new ArrayList<>();
        // [time, tweetId, userId, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int following : followings) {
            if (!tweets.containsKey(following)) {
                continue;
            }
            List<int[]> list = tweets.get(following);
            int[] recent = list.get(list.size() - 1);
            pq.offer(new int[]{recent[1], recent[0], following, list.size() - 1});
            if (pq.size() > 10) {
                pq.poll();
            }
        }

        for (int i = 0; i < 10; i++) {
            if (pq.isEmpty()) {
                break;
            }
            int[] cur = pq.poll();
            res.add(cur[1]);
            if (cur[3] == 0) {
                continue;
            }
            int[] next = tweets.get(cur[2]).get(cur[3] - 1);
            pq.offer(new int[]{next[1], next[0], cur[2], cur[3] - 1});
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) {
            return;
        }
        follows.get(followerId).remove(followeeId);
    }
}
