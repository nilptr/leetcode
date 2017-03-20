public class Twitter {
    private int cursor;
    private Map<Integer, List<Pair>> tweets;
    private Map<Integer, Set<Integer>> relations;

    /** Initialize your data structure here. */
    public Twitter() {
        this.cursor = 0;
        this.tweets = new HashMap<>();
        this.relations = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (tweets.containsKey(userId)) {
            List<Pair> list = tweets.get(userId);
            list.add(new Pair(cursor++, tweetId));
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(cursor++, tweetId));
            tweets.put(userId, list);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Queue<Pair> queue =  new PriorityQueue<>(10, comparator);
        List<Integer> list = new ArrayList<>(10);
        Set<Integer> followees = relations.getOrDefault(userId, new HashSet<>());
        followees.add(userId); // copy
        for (int uid : followees) {
            List<Pair> t = tweets.getOrDefault(uid, new ArrayList<>(0));
            if (t.size() > 10) {
                t = t.subList(t.size() - 10, t.size());
            }
            for (Pair pair : t) {
                queue.add(pair);
            }
        }
        for (int i = 0; i < 10; ++i) {
            Pair p = queue.poll();
            if (p == null) break;
            list.add(p.tweetId);
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (relations.containsKey(followerId)) {
            Set<Integer> set = relations.get(followerId);
            set.add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            relations.put(followerId, set);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (relations.containsKey(followerId)) {
            Set<Integer> set = relations.get(followerId);
            set.remove(followeeId);
        }
    }

    private class Pair {
        final int index;
        final int tweetId;

        Pair(int idx, int id) {
            this.index = idx;
            this.tweetId = id;
        }
    }

    private static final Comparator<Pair> comparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o2.index - o1.index;
        }
    };
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
