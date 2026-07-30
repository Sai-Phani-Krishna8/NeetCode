class TimeMap {
    private Map<String, List<int[]>> keyStore;
    private Map<String, List<String>> valueStore;

    public TimeMap() {
        keyStore = new HashMap<>();
        valueStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k->new ArrayList<>()).add(new int[]{timestamp});
        valueStore.computeIfAbsent(key, k->new ArrayList<>()).add(value);
    }
    
    public String get(String key, int timestamp) {
        List<int[]> times = keyStore.get(key);
        if(times == null) {
            return "";
        }
        
        String res = "";
        List<String> values = valueStore.get(key);
        int left = 0, right = times.size()-1;
        while(left<=right) {
            int mid = left + (right - left) / 2;

            if(times.get(mid)[0] <= timestamp) {
                res = values.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
