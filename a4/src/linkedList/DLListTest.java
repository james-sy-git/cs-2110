package linkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DLListTest {

    @Test
    public void testConstructor() {
        DLList<Integer> d= new DLList<>();
        assertEquals("[]", d.toString());
        assertEquals("[]", d.toStringRev());
        assertEquals(0, d.size());
    }

    @Test
    public void testAppendAndToStringRev() {
        DLList<String> dl= new DLList<String>();
        dl.append("2110");
        assertEquals("[2110]", dl.toString());
        assertEquals("[2110]", dl.toStringRev());
        assertEquals(1, dl.size());
        assertEquals("2110", dl.head().value());
        assertEquals("2110", dl.tail().value());
        
        DLList<String> onenull= new DLList<String>();
        onenull.append(null);
        assertEquals("[null]", onenull.toString());
        assertEquals("[null]", onenull.toStringRev());
        assertEquals(1, onenull.size());
        assertEquals(null, onenull.head().value());
        assertEquals(null, onenull.tail().value());
        
        DLList<String> nullandone= new DLList<String>();
        nullandone.append(null);
        nullandone.append("afternull");
        assertEquals("[null, afternull]", nullandone.toString());
        assertEquals("[afternull, null]", nullandone.toStringRev());
        assertEquals(2, nullandone.size());

        DLList<String> d= new DLList<String>();
        d.append("1110");
        d.append("2110");
        assertEquals("[1110, 2110]", d.toString());
        assertEquals("[2110, 1110]", d.toStringRev());
        assertEquals(2, d.size());

        DLList<Integer> dd= new DLList<Integer>();
        dd.append(1);
        dd.append(2);
        dd.append(3);
        assertEquals("[1, 2, 3]", dd.toString());
        assertEquals("[3, 2, 1]", dd.toStringRev());
        assertEquals(3, dd.size());
        
        DLList<String> empty2= new DLList<String>();
        empty2.append("");
        empty2.append("");
        assertEquals("[, ]", empty2.toString());
        assertEquals("[, ]", empty2.toStringRev());
        assertEquals(2, empty2.size());
    }

    @Test
    public void testPrependAndToStringRev() {
        DLList<String> ddd= new DLList<String>();
        ddd.prepend("2110");
        assertEquals("[2110]", ddd.toString());
        assertEquals("[2110]", ddd.toStringRev());
        assertEquals(1, ddd.size());
        assertEquals("2110", ddd.head().value());
        assertEquals("2110", ddd.tail().value());
        
        DLList<String> onenull= new DLList<String>();
        onenull.prepend(null);
        assertEquals("[null]", onenull.toString());
        assertEquals("[null]", onenull.toStringRev());
        assertEquals(1, onenull.size());
        assertEquals(null, onenull.head().value());
        assertEquals(null, onenull.tail().value());
        
        DLList<String> nullandone= new DLList<String>();
        nullandone.prepend(null);
        nullandone.prepend("beforenull");
        assertEquals("[beforenull, null]", nullandone.toString());
        assertEquals("[null, beforenull]", nullandone.toStringRev());
        assertEquals(2, nullandone.size());

        DLList<String> da= new DLList<String>();
        da.prepend("2110");
        da.prepend("1110");
        assertEquals("[1110, 2110]", da.toString());
        assertEquals("[2110, 1110]", da.toStringRev());
        assertEquals(2, da.size());

        DLList<Integer> dddd= new DLList<Integer>();
        dddd.prepend(1);
        dddd.prepend(2);
        dddd.prepend(3);
        assertEquals("[3, 2, 1]", dddd.toString());
        assertEquals("[1, 2, 3]", dddd.toStringRev());
        assertEquals(3, dddd.size());
        
        DLList<String> empty2= new DLList<String>();
        empty2.prepend("");
        empty2.prepend("");
        assertEquals("[, ]", empty2.toString());
        assertEquals("[, ]", empty2.toStringRev());
        assertEquals(2, empty2.size());
    }

    @Test
    public void testNode() {
        DLList<String> a= new DLList<String>();
        a.prepend("2110");
        assertEquals("[2110]", a.toString());
        assertEquals("[2110]", a.toStringRev());
        assertEquals(1, a.size());
        assertEquals(a.head(), a.node(0));
        assertEquals(null, a.node(0).next());

        DLList<String> aaa= new DLList<String>();
        aaa.append("2110");
        aaa.prepend("1110");
        assertEquals("[1110, 2110]", aaa.toString());
        assertEquals("[2110, 1110]", aaa.toStringRev());
        assertEquals(2, aaa.size());
        assertEquals("2110", aaa.node(1).value());
        assertEquals("1110", aaa.node(1).prev().value());
        assertEquals(null, aaa.node(1).next());

        DLList<Integer> aa= new DLList<Integer>();
        aa.prepend(1);
        aa.prepend(2);
        aa.prepend(3);
        aa.prepend(4);
        assertEquals("[4, 3, 2, 1]", aa.toString());
        assertEquals("[1, 2, 3, 4]", aa.toStringRev());
        assertEquals(4, aa.size());
        assertEquals(3, aa.node(1).value());
        assertEquals(4, aa.node(1).prev().value());
        assertEquals(2, aa.node(1).next().value());
        
        DLList<Integer> withnull= new DLList<Integer>();
        withnull.prepend(7);
        withnull.append(null);
        withnull.append(17);
        assertEquals("[7, null, 17]", withnull.toString());
        assertEquals("[17, null, 7]", withnull.toStringRev());
        assertEquals(3, withnull.size());
        assertEquals(null, withnull.node(1).value());
        assertEquals(7, withnull.node(1).prev().value());
        assertEquals(17, withnull.node(1).next().value());
        
    }

    @Test
    public void testInsertBefore() {
        DLList<String> c= new DLList<String>();
        c.append("2110");
        c.insertBefore(c.head(), "hello");
        assertEquals("[hello, 2110]", c.toString());
        assertEquals("[2110, hello]", c.toStringRev());
        assertEquals(2, c.size());
        assertEquals("hello", c.head().value());

        DLList<String> ccc= new DLList<String>();
        ccc.append("2110");
        ccc.prepend("1110");
        ccc.insertBefore(ccc.tail(), "3110");
        assertEquals("[1110, 3110, 2110]", ccc.toString());
        assertEquals("[2110, 3110, 1110]", ccc.toStringRev());
        assertEquals(3, ccc.size());
        assertEquals("3110", ccc.tail().prev().value());

        DLList<Integer> cc= new DLList<Integer>();
        cc.append(1);
        cc.append(2);
        cc.append(3);
        cc.append(4);
        cc.insertBefore(cc.head(), 0);

        assertEquals("[0, 1, 2, 3, 4]", cc.toString());
        assertEquals("[4, 3, 2, 1, 0]", cc.toStringRev());
        assertEquals(5, cc.size());
        assertEquals(0, cc.head().value());
    }

    @Test
    public void testDelete() {
        DLList<String> f= new DLList<String>();
        f.append("2110");
        f.insertBefore(f.head(), "hello");
        f.delete(f.head());
        assertEquals("[2110]", f.toString());
        assertEquals("[2110]", f.toStringRev());
        assertEquals(1, f.size());
        assertEquals(f.head(), f.node(0));
        assertEquals(null, f.head().prev());

        DLList<String> fff= new DLList<String>();
        fff.append("2110");
        fff.delete(fff.head());
        assertEquals("[]", fff.toString());
        assertEquals("[]", fff.toStringRev());
        assertEquals(0, fff.size());

        DLList<Integer> ff= new DLList<Integer>();
        ff.append(1);
        ff.append(2);
        ff.append(3);
        ff.append(4);
        ff.delete(ff.head());

        assertEquals("[2, 3, 4]", ff.toString());
        assertEquals("[4, 3, 2]", ff.toStringRev());
        assertEquals(3, ff.size());
        assertEquals(2, ff.node(0).value());
        assertEquals(null, ff.node(0).prev());

        DLList<Integer> fg= new DLList<Integer>();
        fg.append(1);
        fg.append(2);
        fg.append(3);
        fg.append(4);
        fg.delete(fg.tail());

        assertEquals("[1, 2, 3]", fg.toString());
        assertEquals("[3, 2, 1]", fg.toStringRev());
        assertEquals(3, fg.size());
        assertEquals(3, fg.node(2).value());
        assertEquals(null, fg.node(2).next());
        
    }

}