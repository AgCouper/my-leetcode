class Solution {
    private int carry;
    private StringBuilder sb;

    public String addBinary(String a, String b) {
        sb = new StringBuilder();

        int len1 = a.length();
        int len2 = b.length();
        if (len1 < len2) {
            var t = a;
            a = b;
            b = t;
        }

        for (int i = 0; i < a.length(); ++i) {
            int idx1 = a.length() - i - 1;
            int idx2 = b.length() - i - 1;

            char c1 = a.charAt(idx1);
            char c2 = idx2 < 0 ? '0' : b.charAt(idx2);
            add(c1, c2);
        }

        if (carry != 0) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public void add(char c1, char c2) {
        int i1 = c1 - '0';
        int i2 = c2 - '0';
        int sum = i1 + i2 + carry;
        char ch = (char)(sum % 2 + '0');
        
        carry = sum > 1 ? 1 : 0;
        sb.append(ch);
    }
}