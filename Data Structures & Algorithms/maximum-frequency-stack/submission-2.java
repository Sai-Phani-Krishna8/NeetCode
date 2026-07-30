class FreqStack {
    private HashMap<Integer, Integer> map;
    private PriorityQueue<int[]> pq;
    private int idx;

    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b) -> (a[0]!=b[0]) ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1]));
        idx = 0;
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0)+1);
        pq.offer(new int[]{map.get(val), idx++, val});
    }

    public int pop() {
        int[] top = pq.poll();
        int val = top[2];
        map.put(val, map.get(val)-1);
        return val;
    }
}