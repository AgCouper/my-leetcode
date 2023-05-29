class TwoSum {
    private final Map<Integer, Integer> vals = new HashMap<>();
    public TwoSum() {
        
    }
    
    public void add(int number) {
        vals.merge(number, 1, Integer::sum);
    }
    
    public boolean find(int value) {
        boolean res = false;
        for (var v : vals.keySet()) {
            int delta = value - v;
            int cnt = vals.getOrDefault(delta, 0);
            if (delta == v) {
                if (cnt == 2) {
                    return true;
                }
            } else if (cnt > 0) {
                return true;
            } 
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */