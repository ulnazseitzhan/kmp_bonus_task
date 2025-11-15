public class KMP {

    /*
     * Builds the LPS (Longest Prefix Suffix) array for the given pattern.
     * LPS[i] = the length of the longest proper prefix of the pattern
               which is also a suffix for the substring pattern[0..i].
     * This array is used to avoid re-checking characters during mismatches.
     * Time Complexity: O(m), where m = pattern length
     */
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int prefixLen = 0; // length of the current longest prefix suffix
        int i = 1;         // index for scanning the pattern

        while (i < pattern.length()) {
            // Case1: characters match, extend the prefix length
            if (pattern.charAt(i) == pattern.charAt(prefixLen)) {
                prefixLen++;
                lps[i] = prefixLen;
                i++;
            }
            // Case2: mismatch after some matches
            else {
                // Roll back prefixLen using previously computed LPS
                if (prefixLen != 0) {
                    prefixLen = lps[prefixLen - 1];
                }
                // If no prefix left, lps[i] = 0
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /*
     * Searches for all occurrences of the pattern in the given text using the KMP algorithm.
     * KMP uses the LPS array to avoid re-checking characters, ensuring linear time.
     * Time Complexity: O(n + m)
     * Space Complexity: O(m)
     */
    public void search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Preprocess the pattern
        int[] lps = buildLPS(pattern);

        int i = 0; // pointer for text
        int j = 0; // pointer for pattern

        while (i < n) {
            // Characters match, move both pointers
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            // Entire pattern matched
            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                // Continue searching for next matches
                j = lps[j - 1];
            }

            // Mismatch after j > 0 matches
            else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                // Move j back using LPS to avoid rechecking characters
                if (j != 0) {
                    j = lps[j - 1];
                }
                // If j == 0, simply move forward in the text
                else {
                    i++;
                }
            }
        }
    }
}
