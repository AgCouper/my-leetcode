/**
 * Given an input string s and a pattern p, implement regular expression 
 * matching with support for '.' and '*' where:
 *  - '.' Matches any single character.​​​​
 *  - '*' Matches zero or more of the preceding element.
 *  The matching should cover the entire input string (not partial).
 */
class Solution {
    /**
     * Represents match context: match string and the current position in it 
     */
    private static class MatchContext {
        private final String s;
        private final int pos;

        public MatchContext(String s, int pos) {
            this.s = s;
            this.pos = pos;
        }

        public char curChar() {
            return s.charAt(pos);
        }

        public MatchContext advance() {
            return new MatchContext(s, pos + 1);
        }

        public boolean isEndOfString() {
            return pos == s.length();
        }
    }

    /**
     * Base class for all individual matchers.
     * Matchers are created as a result of parsing regular expression.
     */
    private abstract static class AbstractMatcher {
        /**
         * Tries to match one or zero chars in the input string
         *
         * @param matchContext context to use for matching
         * @return match context after successful matching, or null if unable to match
         */
        public abstract MatchContext tryMatchFirst(MatchContext matchContext);

        /**
         * Works in context provided in tryMatchFirst. Tries alternative matching,
         * i.e. for asteriks tries to match more characters.
         *
         * @return match context after successful matching, or null if unable to match
         */
        public MatchContext tryMatchNext() {
            return null;
        }

        /**
         * Parses regular expression, creating list of matchers as a result
         * 
         * @param p regular expression string
         * @return list of matchers created as a result of parsing regular expression 
         */
        private static List<AbstractMatcher> parseRegExp(String p) {
            List<AbstractMatcher> res = new ArrayList<>();
            for (int pos = 0; pos < p.length(); pos++) {
                char c = p.charAt(pos);
                if (c == '.') {
                    res.add(new DotMatcher());
                } else if (c == '*') {
                    // this is safe according to the problem description
                    AbstractMatcher prevMatcher = res.get(res.size() - 1);
                    res.set(res.size() - 1, new AsteriksMatcher(prevMatcher));
                } else {
                    res.add(new CharMatcher(c));
                }
            }

            res.add(new EndOfStringMatcher());
            return res;
        }
    }

    /**
     * Matcher for '.'
     */
    private static final class DotMatcher extends AbstractMatcher {
        @Override
        public MatchContext tryMatchFirst(MatchContext matchContext) {
            if (matchContext.isEndOfString()) {
                return null;
            }

            // '.' is any characters, so just advance match context
            return matchContext.advance();
        }
    }

    /**
     * Single character matcher
     */
    private static final class CharMatcher extends AbstractMatcher {
        private final char matchChar;

        private CharMatcher(char matchChar) {
            this.matchChar = matchChar;
        }

        @Override
        public MatchContext tryMatchFirst(MatchContext matchContext) {
            if (matchContext.isEndOfString()) {
                return null;
            }
           
            return matchContext.curChar() == matchChar? matchContext.advance() : null;
        }
    }

    /**
     * Asteriks matcher
     */
    private static final class AsteriksMatcher extends AbstractMatcher {
        // context provided in tryMatchFirst
        private MatchContext matchContext;

        // matcher for character behind asteriks in the regular expression
        private final AbstractMatcher matcher;

        private AsteriksMatcher(AbstractMatcher matcher) {
            this.matcher = matcher;
        }

        @Override
        public MatchContext tryMatchFirst(MatchContext matchContext) {
            this.matchContext = matchContext;

            // first try: match zero characters in the string, so context is unchanged
            return matchContext;
        }

        @Override
        public MatchContext tryMatchNext() {
            // try to match one more char
            matchContext = matcher.tryMatchFirst(matchContext);
            if (matchContext == null) {
                return null;
            }

            return matchContext;
        }
    }

    /**
     * Special matcher: matches when end of the input string is reached
     */
    private static final class EndOfStringMatcher extends AbstractMatcher {
        @Override
        public MatchContext tryMatchFirst(MatchContext matchContext) {
            return matchContext.isEndOfString()? matchContext : null;
        }
    }

    public boolean isMatch(String s, String p) {
        // parse the input regular expression
        List<AbstractMatcher> matchers = AbstractMatcher.parseRegExp(p);

        // initial match context
        MatchContext matchContext = new MatchContext(s, 0);

        // try to apply matchers one by one
        for (int matcherPos = 0; matcherPos < matchers.size(); ++matcherPos) {
            AbstractMatcher matcher = matchers.get(matcherPos);
            matchContext = matcher.tryMatchFirst(matchContext);

            // failed to match, need to backtrack
            if (matchContext == null) {
                // do the backtracking
                while (--matcherPos >= 0) {
                    matcher = matchers.get(matcherPos);
                    // try the alternative matching
                    matchContext = matcher.tryMatchNext();
                    if (matchContext != null) {
                        // alternative matching was successful, stop the backtracking
                        break;
                    }
                }

                // no more matchers to backtrack, so match is unsuccessful
                if (matcherPos < 0) {
                    return false;
                }
            } 
        }

        return true;
    }
}