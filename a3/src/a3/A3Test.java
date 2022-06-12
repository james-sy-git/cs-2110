package a3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class A3Test {

    @Test
    void testMidsAreEqual() {
        assertEquals(true, A3.midsAreEqual(""));
        assertEquals(true, A3.midsAreEqual("$"));
        assertEquals(false, A3.midsAreEqual("23"));
        assertEquals(true, A3.midsAreEqual("44"));
        assertEquals(false, A3.midsAreEqual("22AB"));
        assertEquals(true, A3.midsAreEqual("2AAB"));
        assertEquals(true, A3.midsAreEqual("A22"));
        assertEquals(true, A3.midsAreEqual("AAA"));
        assertEquals(false, A3.midsAreEqual("AABC"));
        assertEquals(true, A3.midsAreEqual("abcdefaabcdefg"));
        assertEquals(false, A3.midsAreEqual("abcdef$abcdefg"));
        assertEquals(true, A3.midsAreEqual("aaaaaaaaaaaaaaaa"));
        assertEquals(false, A3.midsAreEqual("aaaaaaa$aaaaaaaa"));
        assertEquals(true, A3.midsAreEqual("aaaaaaa$aaaaaaaaa"));
        assertEquals(true, A3.midsAreEqual("abcdefgAAAabcdefg"));
    }

    @Test
    void testSurroundLittles() {
        assertEquals("", A3.surroundLittles(""));
        assertEquals("BbB", A3.surroundLittles("b"));
        assertEquals("B", A3.surroundLittles("B"));
        assertEquals("å", A3.surroundLittles("å"));
        assertEquals("$", A3.surroundLittles("$"));
        assertEquals("1ABCDEFXxX", A3.surroundLittles("1ABCDEFx"));
        assertEquals("1ZzZZ$BBbBYyY", A3.surroundLittles("1zZ$Bby"));
        assertEquals("AaABbBCcCDdDEeEFfFGgGHhHIiIJjJKkK",
            A3.surroundLittles("abcdefghijk"));
        assertEquals("LlLMmMNnNOoOPpPQqQRrRSsSTtT",
            A3.surroundLittles("lmnopqrst"));
        assertEquals("UuUVvVWwWXxXYyYZzZ",
            A3.surroundLittles("uvwxyz"));
    }

    @Test
    void testPutCapsFirst() {
        assertEquals("", A3.putCapsFirst(""));

        assertEquals("$", A3.putCapsFirst("$"));
        assertEquals("Ac", A3.putCapsFirst("cA"));
        assertEquals("cÅc", A3.putCapsFirst("cÅc"));
        assertEquals("ABCDXZabcdxy$z", A3.putCapsFirst("aAbBcCdDxXy$zZ"));
        assertEquals("mnopqrst", A3.putCapsFirst("mnopqrst"));
        assertEquals("1z$aàēĤƀ", A3.putCapsFirst("1z$aàēĤƀ"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ.$%!",
            A3.putCapsFirst("ABCDE.FGHIJKLMNO$PQ%RSTUV!WXYZ"));
    }

    @Test
    void testMoreThan1() {
        assertEquals(false, A3.moreThan1("", ""));
        assertEquals(true, A3.moreThan1("a", ""));
        assertEquals(false, A3.moreThan1("", "a"));
        assertEquals(false, A3.moreThan1("abcb", "c"));
        assertEquals(true, A3.moreThan1("acbcb", "c"));
        assertEquals(false, A3.moreThan1("abbb", "c"));
        assertEquals(true, A3.moreThan1("aaa", "aa"));
        assertEquals(false, A3.moreThan1("abbc", "ab"));
        assertEquals(true, A3.moreThan1("aaa", "a"));
        assertEquals(true, A3.moreThan1("abbbabc", "ab"));
        assertEquals(true, A3.moreThan1("what if what if what", "what"));
        assertEquals(true, A3.moreThan1("what if what if what", "what if"));
        assertEquals(true, A3.moreThan1("what if what if what", "what if what"));
        assertEquals(false, A3.moreThan1("what if what if what", "what if what if"));
    }

    @Test
    void testDuplicate() {
        assertEquals("", A3.duplicate(" b0 "));
        assertEquals("c", A3.duplicate("        c1"));
        assertEquals("$$$$$$$$", A3.duplicate("$8        "));
        assertEquals("33333", A3.duplicate("35"));
    }

    @Test
    void testAreAnagrams() {
        // assertEquals(true, A3.areAnagrams("", ""));
        assertEquals(true, A3.areAnagrams("noon", "noon"));
        assertEquals(true, A3.areAnagrams("mary", "army"));
        assertEquals(true, A3.areAnagrams("tom marvolo riddle", "i am lordvoldemort"));
        assertEquals(false, A3.areAnagrams("tommarvoloriddle", "i am lordvoldemort"));
        assertEquals(false, A3.areAnagrams("world", "hello"));
        assertEquals(false, A3.areAnagrams("a", "A"));
    }

}
