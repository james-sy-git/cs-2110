package a2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class A2Test {

    @Test
    void testSum1() {
        assertEquals(21, A2.sum1());
    }

    @Test
    void testSum2() {
        assertEquals(1, A2.sum2(1));
        assertEquals(30, A2.sum2(6));
    }

    @Test
    void testSum3() {
        assertEquals(-1, A2.sum3(4, 5));
        assertEquals(3, A2.sum3(0, 5));
    }

    @Test
    void testSum4() {
        assertEquals(17, A2.sum4(4, 5));
        assertEquals(16, A2.sum4(4, 2));
    }

    @Test
    void testConditional() {
        assertEquals(5, A2.conditional(4, 5));
        assertEquals(8, A2.conditional(4, 4));
        assertEquals(14, A2.conditional(7, 2));
    }

    @Test
    void testP() {
        System.out.println("Test of p(0). Should print 1:");
        A2.p(0);
        System.out.println("Test of p(2). Should print 4:");
        A2.p(2);
        System.out.println("Test of p(-10). Should print -20:");
        A2.p(-10);
    }

    @Test
    void testLocal1() {
        assertEquals(10, A2.local1(2, 4));
        assertEquals(6, A2.local1(2, 2));
        assertEquals(5, A2.local1(2, 1));
    }

    @Test
    void testLoop1() {
        assertEquals(18, A2.loop1(3, 6));
        assertEquals(2, A2.loop1(2, 2));
        assertEquals(0, A2.loop1(2, 1));
    }

    @Test
    void testLoop2() {
        assertEquals(10, A2.loop2(3, 6));
        assertEquals(12, A2.loop2(2, 6));
        assertEquals(10, A2.loop2(3, 7));
        assertEquals(18, A2.loop2(3, 8));
    }

    @Test
    void testLoop3() {
        assertEquals(5, A2.loop3(3, 6));
        assertEquals(25, A2.loop3(26, 28));
        assertEquals(25, A2.loop3(25, 28));
        assertEquals(25, A2.loop3(26, 28));
        assertEquals(26, A2.loop3(27, 28));
        assertEquals(30, A2.loop3(30, 30));
        assertEquals(28, A2.loop3(29, 29));

    }

    @Test
    void testLoop4() {
        assertEquals(10, A2.loop4(3, 6));
        assertEquals(12, A2.loop4(2, 6));
        assertEquals(10, A2.loop4(3, 7));
        assertEquals(18, A2.loop4(3, 8));
    }

    @Test
    void testLoop5() {
        assertEquals(1, A2.loop5(1));
        assertEquals(1, A2.loop5(2));
        assertEquals(3, A2.loop5(3));
        assertEquals(1, A2.loop5(4));
        assertEquals(5, A2.loop5(5));
        assertEquals(3, A2.loop5(6));
        assertEquals(7, A2.loop5(7));
        assertEquals(1, A2.loop5(8));
        assertEquals(9, A2.loop5(9));
        assertEquals(5, A2.loop5(10));
        assertEquals(11, A2.loop5(11));
        assertEquals(3, A2.loop5(12));
        assertEquals(13, A2.loop5(13));
        assertEquals(7, A2.loop5(14));
        assertEquals(15, A2.loop5(15));
        assertEquals(1, A2.loop5(16));
        assertEquals(125, A2.loop5(1000));
        assertEquals(1, A2.loop5(32768));

    }

}
