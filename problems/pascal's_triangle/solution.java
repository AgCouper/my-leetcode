/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
*/
class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(List.of(1));
        if (n == 1) {
            return t;
        }

        t.add(List.of(1, 1));
        for (int i = 2; i < n; i++) {
            List<Integer> r = new ArrayList<>(i + 1);
            r.add(1);
            List<Integer> pr = t.get(i - 1);
            for (int j = 1; j < i; j++) {
                r.add(pr.get(j - 1) + pr.get(j));
            }

            r.add(1);
            t.add(r);
        }

        return t;
    }
}