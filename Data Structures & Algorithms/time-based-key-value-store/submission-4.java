public class TimeMap {

    private Map<String, List<String[]>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyStore
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(new String[]{String.valueOf(timestamp), value});
    }

    public String get(String key, int timestamp) {
        List<String[]> values = keyStore.get(key);

        if (values == null) {
            return "";
        }

        int left = 0;
        int right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int storedTimestamp = Integer.parseInt(values.get(mid)[0]);

            if (storedTimestamp <= timestamp) {
                result = values.get(mid)[1];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}