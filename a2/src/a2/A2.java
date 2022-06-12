package a2;

/* Please provide the following information.
 * For items 1 and 2, if two people, separate entries by a comma.
 * For items 3, 4, and 5, use the first line for the first person AND
 *     the second line for the second person if there is one.
 *
 * 1. Name(s): James Sy
 * 2. Netid(s): jcs547
 * 3. Took CS1110 (yes or no): yes
 * 3. Took CS1110 (yes or no):
 * 4: Took CS1112 (yes or no): no
 * 4: Took CS1112 (yes or no):
 * 5. I know Java (yes or no): no
 * 5. I know Java (yes or no):
 * 6. Tell us what you thought of this assignment: It was very useful to see how
 * the logic and skills I learned in Python during CS1110 transfer over to Java.
 *
 *
 */

/** This class contains simple methods for you to learn<br>
 * Java syntax and semantics. Class A2Test contains all the test<br>
 * cases needed to check that the methods were written correctly.
 *
 * Most methods have a comment at the beginning of the body giving you<br>
 * instructions for writing it and perhaps showing you where to look in<br>
 * JavaHyperText for more information.
 *
 * Each function body has in it a return statement. Without it, the function<br>
 * won't compile. Replace the return statement by the code you write to implement <br>
 * the spec (we often abbreviate "specification" by "spec").
 *
 * After you complete a method, look at the procedure in A2Test.java that <br>
 * tests it. Click on the name of the function. Then use menu item Run -> Run. <br>
 * That method will be called to test whether you wrote the method correctly.
 *
 * @author david gries */
public class A2 {

    /** Replace "-1" by the time you spent on A2 in hours.<br>
     * Example: for 1 hours 15 minutes, use 1.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= 1.10;

    /** Return the sum of the values 6, 7, 8 */
    public static int sum1() {
        /*TODO 1: This requires only one line of code: a return statement.
         * Method sum1 is a FUNCTION, since its return type is "int".
         *
         * Look at entry   return   in JavaHyperText and read about a return
         * statement in a function. We will use the return statement in a
         * procedure later. */
        return (6 + 7 + 8);
    }

    /** If x = 1, return 1; <br>
     * Otherwise, return the sum of the values 6, 7, 8, 9 */
    public static int sum2(int x) {
        /* TODO 2: This and the next 4-5 methods require an if-statement or an
         * if-else statement. Open the pdf file at JavaHyperText entry
         *    if-statement    and keep it open for reference for these methods.
         * In the pdf file, look at the first, leftmost example. Use
         * that form, but instead of "x= y;" use a return statement.
         * Thus:
         *
         * 1. Implement the first statement in the specification: Write an
         * if-statement whose then-part returns 1.
         *
         * 2. Implement the second line of the spec. Write
         * a return statement. That's it.
         *
         * Study the syntax/semantics of the if-statement at the bottom of the
         * pdf file.
         */
    	if (x == 1) return 1;
    	
    	return (6 + 7 + 8 + 9);
    	}


    /** If x = 0, set x to y and y to 2.<br>
     * Then return the value of x - y. */
    public static int sum3(int x, int y) {
        /* TODO 3: Read JavaHyperText entry   block   .
         *
         * If the then-part of an if-statement requires several statements,
         * we write the then-part as a block with those statements inside it.
         *
         * 1. Translate the first sentence of the spec into a Java
         * if-statement. You will use a block.
         *
         * 3. Translate the second sentence of the spec into a Java
         * return statement. */

        if (x == 0) {
        	x = y;
        	y = 2;
        }
        
        return (x - y);
    }

    /** If x <= y, set x to y and y to 2; otherwise, set y to x.<br>
     * Then return the value of 3x + y. */
    public static int sum4(int x, int y) {
        /* TODO 4: Read about the if-else statement in JavaHyperText. In particular,
         * read about its syntax/semantics at the bottom of the page of the pdf file.
         *
         * In this method, an if-else statement is needed.
         * To write this method, first translate the first sentence into
         * an if-else statement; then translate the second sentence into
         * a return statement. */
    	
    	if (x <= y) {
    		x = y;
    		y = 2;
    	}
    	else {
    		y = x;
    	}
    	
        return (3*x + y);
    }

    /** If x < y, return y; otherwise return 2x. */
    public static int conditional(int x, int y) {
        /* TODO 5: This exercise concerns the "conditional expression", a very
         * useful tool. Type   ?   into the JavaHyperText Filter Field and read
         * about it.
         *
         * Write this method body as a single, one-line, return statement
         * whose expression is a conditional expression. */
        return x < y ? y : 2*x;
    }

    /** If x = 0, print 1; <br>
     * Otherwise, print 2x */
    public static void p(int x) {
        /* TODO 6: This exercise introduces you to the return statement in a
         * procedure --a method with return type  void . Type
         *    return   into the JavaHyperText Filter Field and read about it.
         *
         * 1. The goal here is to get you to see that execution of the return
         * statement terminates execution of the method body; nothing else
         * happens in this method after that.
         *
         * 2. Within the JUnit testing class, the only way to know that this
         * method does the right thing is to look at what it prints in the
         * Console. That's not so good but we live with it. Look at how we
         * do that in method testP, annotating what is printed to help the reader.
         * Don't use this way of testing, by looking at printed output,
         * unless there is no other choice.
         *
         * 3. To print the value of an expression like b + c, write:
         *      System.out.println(b+c);
         *
         * 4. Write this method with two statements:
         *    (1) An if-statement that performs the first line of the spec
         *        and returns, using a return statement.
         *    (2) A print statement that performs the second line of the spec.
         */

    	if (x == 0) {
    		System.out.println(1);	
    		return;
    	}
    	
    	System.out.println(2*x);
    }

    /** If b < c, then swap b and c.<br>
     * Then return the value of 2b + c. */
    public static long local1(long b, long c) {
        /* TODO 7: This exercise introduces you to local variables.
         * Open the pdf file in JavaHyperText entry   local variable   and
         * study the first part, about declarations of local variables. Study
         * the short method that appears to the right on that page.
         *
         * To write this method:
         * (1) Translate the first sentence of the spec into a Java
         *     if-statement.
         * (2) Translate the second sentence of the spec into a Java
         *     return statement. */
        
    	if (b < c) {
    		long k = b;
    		b = c;
    		c = k;
    	}
    	
    	return (2*b + c);
    	
    }

    /** Return 0. */
    public static double local2(double b, double c) {
        /* TODO 8: The pdf file on local variables tells you that local
         * variables are uninitialized. To gain experience with this fact,
         * replace the value  0  in the return statement by  m  . What
         * happens? Once you understand, change the   m  back to 0 so the
         * method compiles. */
        int m;
        
        return 0;
    }

    /** Return the sum of values in n..m. <br>
     * Note: we use n..m to denote the values n, n+1, n+2, ..., m. */
    public static int loop1(int n, int m) {
        /* TODO 9: In JavaHyperText, open the pdf file at entry   for-loop
         * and study the material down to point 6 about for-loops.
         *
         * Write a loop in this method body so that the specification
         * is implemented. The first statement should declare a local
         * variable, say s, to contain the sum.
         *
         * Note: if n > m, the sum is 0. Do not write a special test
         * for this case. Your loop should handle it: 0 iterations
         * will be executed. */
        int t = 0;
        for (int i = n; i <= m; i++) {
        	t = t+i;
        }
        
        return t;
    }

    /** Return the sum of the even values in n..m. */
    public static int loop2(int n, int m) {
        /* TODO 10: Sometimes, it is easier to declare and initialize the
         * loop counter before the loop. Then, the loop initialization
         * can be empty. (See pt 3 of the for-loop pdf file) That's the case here.
         * Set it to either n or n+1 depending on which is even. .
         *
         * Write this method declaring the loop counter before the loop,
         * setting the loop counter to n or n+1, depending on which is even.
         * Also, the increment of the for-loop should increase the loop
         * counter by 2.
         * Use n%2 == 0 to test whether n is even.
         */
    	int k = 0;
    	int s;
        if (n % 2 == 0) {
        	s = n;
        }
        else {
        	s = n + 1;
        }
        for (; s <= m; s++) {
        	if (s % 2 == 0) k = k + s;
        }
        
        return k;
    }

    /** Return the last value of n..m that is divisible by 5 <br>
     * return n-1 if none. */
    public static int loop3(int n, int m) {
        /* TODO 11: Your for-loop you should decrease the control
         * variable by 1 after each iteration.
         * Use k%5 == 0 to test whether k is divisible by 5.
         * The repetend should execute a return statement when the answer
         * is found.
         *
         * Do NOT declare any local variables except the loop counter.
         * Do NOT use a break statement within the repetend; use a return
         * statement. */
        for (int k = m; k >= n; k--) {
        	if (k % 5 == 0) return k;
        }
        
        return (n - 1);
    }

    /** Return the sum of the even values in n..m. */
    public static int loop4(int n, int m) {
        /* TODO 12: The next set of methods deal with the while-loop.
         * Open the pdf file in entry    while-loop   in JavaHyperText and
         * read about the while loop. Don't look at point 4; we'll cover
         * that later in the course.
         *
         * This method does the same thing as method loop2. But
         * write it using a while-loop.
         */

        int k = n;
    	int a = 0;
        while (k <= m) {
        	if (k % 2 == 0) {
        		a = a + k;
        	}
        	k = k + 1;
        }
        
        return a;
    }

    /** Any positive integer n can be written in this form: c*2^y, where <br>
     * both c and y are positive and c is odd. <br>
     * Return the value c. <br>
     * Precondition: n > 0 */
    public static int loop5(int n) {
        /* TODO 13: Write a while-loop that continually divides n by 2
         * until n is odd (it may be odd initially). Then return n.
         *
         * Use   n%2 == 0   to test whether n is even.
         *
         * When you have completed this, DO TWO THINGS:
         * 1. On or about line 42, enter the time you spent on A3.
         *
         * 2. Fill in the information in the comment at the top of this file,
         * including what you thought of this assignment. */
        while (n % 2 == 0) n = n/2;
        
        return n;
    }

}
