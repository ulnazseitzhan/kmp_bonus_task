public class Main {

    public static void main(String[] args) {

        KMP kmp = new KMP();

        System.out.println("\n TEST 1: Short String");
        kmp.search("abcabc", "abc");

        System.out.println("\n TEST 2: Medium String ");
        kmp.search("aaabaaabaaabaaa", "aab");

        System.out.println("\n TEST 3: Long String");
        // Large input to demonstrate linear performance
        String longText = "a".repeat(100000) + "b";
        kmp.search(longText, "ab");
    }
}
