class TimeMap {
    private Map<String, List<LogItem>> outerMap; 
    
    public TimeMap() {
        outerMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        LogItem logItem = new LogItem(value, timestamp);
        outerMap.computeIfAbsent(key, k -> new ArrayList<>()).add(logItem);
    }
    
    public String get(String key, int timestamp) {
        if (!outerMap.containsKey(key)) return "";
        return findMostRecentValueFromTimestamp(outerMap.get(key), timestamp);
    }
    
    private String findMostRecentValueFromTimestamp(List<LogItem> logItems, int stamp) {      
        int left = 0, right = logItems.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midTimestamp = logItems.get(mid).getStamp();
            if (midTimestamp == stamp) {
                return logItems.get(mid).getValue();
            } else if (midTimestamp > stamp) {
                right = mid - 1;
            } else { // midTimestamp < stamp
                left = mid + 1;
            }
        }
        // If the while loop ends, the correct value is to the left of 'left', if it exists
        return left > 0 ? logItems.get(left - 1).getValue() : "";
    }
}

class LogItem {
    private String value;
    private int stamp;
    
    public LogItem(String value, int stamp) {
        this.value = value;
        this.stamp = stamp;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public int getStamp() {
        return this.stamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */