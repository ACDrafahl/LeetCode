class RecentCounter {
    Queue<Integer> pingQueue;

    public RecentCounter() {
        pingQueue = new LinkedList<>();
    }
    
    public int ping(int t) {
        pingQueue.offer(t);

        while (t - pingQueue.peek() > 3000) {
            pingQueue.poll();
        }
        return pingQueue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */