package a3;

import java.util.Arrays;

/* NetIds: jcs547, wzs6
 * What I thought about this assignment: 
 * This assignment forced me to think in unconventional ways, such as when we
 * could not use loops for some of the methods. This taught me how to optimize
 * my programs to save memory.
 *  */

/** A collection of static functions manipulating strings. <br>
 * All methods assume that String parameters are non-null.
 *
 * If a method is called with arguments that do not satisfy the Preconditions,<br>
 * the behavior is undefined (the method can do anything). You do not have to use assert<br>
 * statements to test Preconditions. We will not test with test cases that do <br>
 * not satisfy Preconditions.
 *
 * In the skeleton code, each method body has one statement:
 *
 * .... throw new UnsupportedOperationException(); <br>
 *
 * It is there only so that the method compiles. Replace that statement by your code. */
public class A3 {
    /* Each function you write has a "//TODO comment". Look on the right; click a blue
     * rectangle to get to the corresponding "//TODO comment".
     * DO NOT DELETE THESE COMMENTS.
     * Put your code AFTER the comments.
     *
     * Wherever possible, prefer library functions to writing your own loops.
     *
     * See the JavaHyperText entries for if-statement, while-loop, and for-loop.
     * Use of the break-statement and continue-statement is discouraged but not
     * forbidden. They make loops and programs harder to understand. Usually,
     * they can be eliminated by restructuring/reorganizing code --perhaps writing
     * extra methods.
     *
     * For some functions, you may be writing a loop to append character after
     * character to an initially empty string. See the JavaHyperText entry for
     * class StringBuilder and a discussion of why it is better to use
     * StringBuilder for this purpose.
     *
     * We give complete test cases.
     *  */

    /** Replace "-1" by the time you spent on A3 in hours.<br>
     * Example: for 3 hours 15 minutes, use 3.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= 1.75;

    /** Return true iff the middle characters of s are the same. <br>
     * Note: If s has an odd number of chars, there is ONE middle char, so return true.<br>
     * If s is "", return true.<br>
     * If s has an even number (>0) of chars, there are two middle chars, so return <br>
     * true iff they are the same.<br>
     * Here are examples: <br>
     * For s = "" return true <br>
     * For s = "$" return true <br>
     * For s = "23" return false <br>
     * For s = "44" return true <br>
     * For s = "22AB" return false <br>
     * For s = "2AAB" return true <br>
     * For s = "abcdefaabcdefg" return true <br>
     * For s = "abcdef$abcdefg" return false <br>
     * For s = "aaaaaaaaaaaaaaaa" return true <br>
     * For s = "aaaaaaa$aaaaaaaa" return false<br>
     * For s = "aaaaaaa$aaaaaaaaa" return false */
    public static boolean midsAreEqual(String s) {
        // TODO 1. Do not use a loop.
        // This can be done cleanly in 3-4 statements (but you can use more).
        // Hint: Follow these Principles:
        // Principle: Avoid unnecessary case analysis
        // Principle: Avoid the same expression in several places.
        // Principle: Keep the structure of the method as simple as possible.

        if ((s.length() % 2 != 0) || (s.length() == 0)) return true;
        return (s.charAt(s.length()/2) == s.charAt(s.length()/2 - 1));
    }

    /** Surround the letters in 'a'..'z' by the corresponding capital. <br>
     * That is: Return a copy of s changed as indicated above. <br>
     * Examples: <br>
     * For s = "", return "". <br>
     * For s = "b", return "BbB". <br>
     * For s = "B", return "B". <br>
     * For s = "å", return "å" <br>
     * For s = "$", return "$" <br>
     * For s = "1ABCDEFx", return "1ABCDEFXxX".<br>
     * For s = "1z$Bby", return "1ZzZ$BBbBYyY"<br>
     * For s = "abcdefghijk", <br>
     * ......... return "AaABbBCcCDdDEeEFfFGgGHhHIiIJjJKkK" <br>
     * For s = "lmnopqrst", <br>
     * ......... return "LlLMmMNnNOoOPpPQqQRrRSsSTtT"<br>
     * For s = "uvwxyz", <br>
     * ......... return "UuUVvVWwWXxXYyYZzZ" */
    public static String surroundLittles(String s) {
        /* TODO 2.
         * 1. The spec does NOT say to handle all lower-case letters
         * differently from the rest, but only letters in 'a'..'z'.
         * There are other lower-case letters!
         *
         * 2. In the fourth example, s = "å", 'å' is lower-case letter but
         * it is NOT a character in a..z, so it is NOT surrounded by a capital.
         *
         * If this isn't working for you, you may be using Eclipse on a
         * Windows 10 computer and the wrong Text File coding is being used.
         * Check that you are using the right one by using menu
         * item Preferences -> General -> Workspace and selecting UTF-8.
         *
         *You can read about text-file encodings in JavaHyperText here:
         *   https://www.cs.cornell.edu/courses/JavaAndDS/eclipse/Ecl01eclipse.html
         *
         * You will lose all points on this question if your code handles
         * all lower-case letters and not just those in a..z.
         *
         * 3. Do NOT use "magic numbers" ---look that term up in JavaHyperText.
         * For example, the internal representation of 'a' is 97, but do NOT
         * use magic number 97 in the method body; instead, use 'a'.
         */
        
        StringBuilder surround = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c >= 'a' && c <= 'z') {
        		surround.append(s.substring(i, i+1).toUpperCase());
        		surround.append(s.substring(i, i+1));
        		surround.append(s.substring(i, i+1).toUpperCase());
        		}
        	else surround.append(s.substring(i, i+1));
        	}
        return surround.toString();
        }

    /** Return s but with all letters in 'A'..'Z' moved to the front, <br>
     * and in the same order.<br>
     * Examples: <br>
     * putCapsFirst("") = "" <br>
     * putCapsFirst("$") = "$" <br>
     * putCapsFirst("cA") = "Ac" <br>
     * putCapsFirst("cÅ") = "cÅ" <br>
     * Note: 'Å' is not in 'A'..'Z'. <br>
     * putCapsFirst("aAbBcCdDxXy$zZ") = "ABCDXZabcdxy$z" <br>
     * putCapsFirst("mnopqrst") = "mnopqrst" <br>
     * putCapsFirst("1z$aàēĤƀ") = "1z$aàēĤƀ"<br>
     * putCapsFirst("ABCDE.FGHIJKLMNO$PQ%RSTUV!WXYZ") = "ABCDEFGHIJKLMNOPQRSTUVWXYZ.$%!" */
    public static String putCapsFirst(String s) {
        // TODO 3. The same things about the UTF-8 encoding and magic numbers
        // discussed in the previous method apply here also.
        //
        // In this method, you must use StringBuilder twice, once to contain
        // the non-capital letters and once to contain all the capitals, to
        // be placed at the front when done.

        StringBuilder caps = new StringBuilder("");
    	StringBuilder other = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c >= 'A' && c <= 'Z') caps.append(s.substring(i, i+1));
        	else other.append(s.substring(i, i+1));
        	}
        
        StringBuilder accum = new StringBuilder("");
        accum.append(caps); accum.append(other);
        
        return accum.toString();
        
    }

    /** Precondition: s and t are not null. <br>
     * Return true iff s contains more than one occurrence of t. <br>
     * Examples: moreThan1("", "") is false <br>
     * moreThan1("a", "") is true: <br>
     * .... The empty string occurs before and after each character! <br>
     *
     * moreThan1("abc", "") is true <br>
     * moreThan1("", "a") is false. <br>
     * moreThan1("abcb", "c") is false. <br>
     * moreThan1("acbc", "c") is true. <br>
     * moreThan1("abbc", "ab") is false. <br>
     * moreThan1("aaa", "aa") is true. <br>
     * moreThan1("abbbabc", "ab") is true. */
    public static boolean moreThan1(String s, String t) {
        // TODO 4 Do not use a loop or recursion. Instead, look through the
        // methods of class String and see how you can check that the first
        // and last occurrences of t in s are different occurrences.
        //
        // Hint: Follow this Principle:
        // Principle: Be aware of efficiency considerations.
        // Don't repeat expensive work that has already been done.
        // Note that a call like s.indexOf(t) may take time proportional to the
        // length of string s. If s contains 1,000 characters and s1 contains 5 chars,
        // then about 9996 tests may have to be made in the worst case. So don't
        // have the same method call executed several times.

        return s.indexOf(t) != s.lastIndexOf(t);
    }

    /** s consists of a nonblank character followed by a digit k (say) in 0..9. <br>
     * There may be blanks before the character and after the digit.<br>
     * Return a String that contains k copies of the character. */
    /* Examples: <br>
    * duplicate("        b0 ") is "" <br>
    * duplicate(" c1        ") is "c" <br>
    * duplicate("$8         ") is "$$$$$$$$" <br>
    * duplicate("35")          is "33333". */
    public static String duplicate(String s) {
        // TODO 5. Do NOT use a loop or recursion. Do not use magic numbers.
        // Rely only on methods of class String.
        // Don't use unnecessary case analysis --a solution needs no if-statements
        // or conditional expressions.

        String ref = s.trim().substring(0,1);
        char i = s.trim().charAt(1);
        
        return ref.repeat(i - 48);
        
    }

    /** Return true iff s and t are anagrams.<br>
     * Note: 2 strings are anagrams of each other if swapping the characters<br>
     * around in one changes it into the other.<br>
     * Note: 'a' and 'A' are different chars, and the space ' ' is a character.
     *
     * Examples: For s = "noon", t = "noon", return true. <br>
     * For s = "mary", t = "army", return true. <br>
     * For s = "tom marvolo riddle", t = "i am lordvoldemort", return true. <br>
     * For s = "tommarvoloriddle", t = "i am lordvoldemort", return false. <br>
     * For s = "hello", t = "world", return false. */
    public static boolean areAnagrams(String s, String t) {
        // TODO 6
        /* Do not use a loop or recursion! This can be done in
         * 5 lines using methods of classes String and Arrays --look them up.
         * Hint: how can a sequence of characters be uniquely ordered? You might
         * need to first convert the string into an array of characters and then
         * use methods in class Arrays. */

        char sarray[] = s.toCharArray();
        char tarray[] = t.toCharArray();
        
        Arrays.sort(sarray);
        Arrays.sort(tarray);
        
        return (Arrays.equals(sarray, tarray));
        
    }

    // TODO 7
    /* This is worth 3/100 points of this assignment.
     * In the comment near lines 5..10, fill in your netid(s) and tell us
     * what you thought about this assignment. Then, in the declaration of
     * static variable timeSpent near line 47, put in
     * how much time you spent on this assignment */

}
