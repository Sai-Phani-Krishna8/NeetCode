class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        
        TreeMap<Integer, String> curMap = map.get(key);

        Integer prevTime = curMap.floorKey(timestamp);

        if (prevTime == null) {
            return "";
        }

        return curMap.get(prevTime);
    }
}
