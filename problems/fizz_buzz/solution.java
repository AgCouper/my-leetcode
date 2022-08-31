class Solution {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = "FizzBuzz";


    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add(FIZZ_BUZZ);    
            } else {
                if (i % 3 == 0) {
                    res.add(FIZZ);
                } else {
                    if (i % 5 == 0) {
                        res.add(BUZZ);
                    } else {
                        res.add(String.valueOf(i));
                    }
                }
            }            
        }
        
        return res;
    }
}