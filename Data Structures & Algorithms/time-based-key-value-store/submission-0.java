class TimeMap {

    class Entry{
        int timestamp;
        String value;

        Entry(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    HashMap<String, List<Entry>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.putIfAbsent(key, new ArrayList<>());
        hm.get(key).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String ans = "";
        if(!hm.containsKey(key)) return "";
        List<Entry> arr = new ArrayList<>();
        arr = hm.get(key);
        int l = 0, r = arr.size() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(arr.get(mid).timestamp == timestamp) return arr.get(mid).value;
            else if(arr.get(mid).timestamp <= timestamp){
                ans = arr.get(mid).value;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */