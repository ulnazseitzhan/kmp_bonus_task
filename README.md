# kmp_bonus_task

KMP String Matching Algorithm — Java Implementation

This repository contains a clean and well-documented implementation of the Knuth–Morris–Pratt (KMP) pattern-matching algorithm in Java.
The project includes:

Source code of the KMP algorithm

English comments in the code

A PDF report explaining the theory and workflow of KMP

Prefix-function (LPS array) explanation

Example input and output

## Project Structure
├── src/
│   ├── KMP.java
│
├── KMP_Report.pdf
├── README.md

# About KMP Algorithm

The KMP algorithm is an efficient string-matching algorithm that avoids re-checking characters by using preprocessed information stored in the LPS (Longest Prefix Suffix) array.

Key features:

Time complexity: O(n + m)

Uses the LPS array to skip unnecessary comparisons

Works faster than brute-force matching for large texts

# How It Works
1. Preprocessing (Build LPS array)

The algorithm computes the LPS array, storing the length of the longest proper prefix which is also a suffix for each prefix of the pattern.

2. Pattern Searching

Using the LPS array, KMP moves through the text without repeating previously matched comparisons.

### Example Usage
public class Main {
    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";

        KMP kmp = new KMP();
        int index = kmp.search(text, pattern);

        System.out.println("Pattern found at index: " + index);
    }
}


Output:

Pattern found at index: 10

### Report

A full report describing:

Problem definition

Key ideas of KMP

Diagram of LPS computation

Algorithm workflow

Code explanation

can be found here:

## KMP_Report.pdf

## Technologies Used

Java (JDK 8+)

IntelliJ IDEA (recommended)

## Author

Created as part of an Algorithms & Data Structures assignment.

If you want, I can also:

- Add a project banner
- Add badges (Java version, build, license)
- Create a full GitHub-style documentation (wiki pages)

##Sample Input/Output section:
Sample Input 1 (Short String)

Text: "abcabc"
Pattern: "abc"

Output:

Pattern found at index 0
Pattern found at index 3

Sample Input 2 (Medium String)

Text: "aaabaaabaaabaaa"
Pattern: "aab"

Output:

Pattern found at index 1
Pattern found at index 5
Pattern found at index 9

Sample Input 3 (Long String)

Text: "a" repeated 100000 times + "b"
Pattern: "ab"

Output:

Pattern found at index 100000
