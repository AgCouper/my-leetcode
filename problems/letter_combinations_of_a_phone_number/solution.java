/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
 * that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. 
 * Note that 1 does not map to any letters.
 *
 */
class Solution {
    private static String[] numToLetters = new String[] {
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<StringBuilder> combs = letterCombinationsInternal(digits);
        return combs.stream().map(sb -> sb.reverse().toString()).toList(); 
    }

    public List<StringBuilder> letterCombinationsInternal(String digits) {
        int d = (int)digits.charAt(0) - (int)'0';
        String letters = numToLetters[d - 2];

        if (digits.length() == 1) {
            List<StringBuilder> res = new ArrayList(letters.length());
            for (int i = 0; i < letters.length(); i++) {
                res.add(new StringBuilder().append(letters.charAt(i)));
            }

            return res;
        }
    
        List<StringBuilder> combs = letterCombinationsInternal(digits.substring(1));
        List<StringBuilder> res = new ArrayList(letters.length() * combs.size());
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            for (var sb : combs) {
                res.add(new StringBuilder(sb).append(letter));
            }
        }

        return res;
    }
}