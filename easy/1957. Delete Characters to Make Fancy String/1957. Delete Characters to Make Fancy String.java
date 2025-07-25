public class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int len = result.length();
            // Add current char only if last two characters are not same as current
            if (len >= 2 && result.charAt(len - 1) == s.charAt(i) && result.charAt(len - 2) == s.charAt(i)) {
                continue;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
