/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 */
class Solution {
    // '{(([()]))'
    public boolean isValid(String s) {
        Deque<TOKEN> tokenStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TOKEN t = TOKEN.fromChar(c);
            if (t == null) {
                return false;
            }

            if (t.isClose) {
                if (tokenStack.isEmpty()) {
                    return false;
                }

                TOKEN tprev = tokenStack.pop();
                if (tprev.type != t.type) {
                    return false;
                }
            } else {
                tokenStack.push(t);
            }
        }

        return tokenStack.isEmpty();   
    }

    private enum TOKEN {
        // square
        S_BRACE_OPEN(0, false),
        S_BRACE_CLOSE(0, true),
        
        // round
        R_BRACE_OPEN(1, false), 
        R_BRACE_CLOSE(1, true),

        // curly
        C_BRACE_OPEN(2, false), 
        C_BRACE_CLOSE(2, true),
        ;

        private final int type;
        private final boolean isClose;

        TOKEN(int type, boolean isClose) {
            this.type = type;
            this.isClose = isClose;
        }

        private static TOKEN fromChar(char ch) {
            return switch (ch) {
                case '[' -> S_BRACE_OPEN;
                case ']' -> S_BRACE_CLOSE;
                case '(' -> R_BRACE_OPEN;
                case ')' -> R_BRACE_CLOSE;
                case '{' -> C_BRACE_OPEN;
                case '}' -> C_BRACE_CLOSE;

                default -> null;
            };
        }
    }
}