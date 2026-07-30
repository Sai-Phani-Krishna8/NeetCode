public class TimeMap {

    private Map<String, List<Entry>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyStore
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Entry> values = keyStore.get(key);

        if (values == null) {
            return "";
        }

        int left = 0;
        int right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Entry current = values.get(mid);

            if (current.timestamp <= timestamp) {
                result = current.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}