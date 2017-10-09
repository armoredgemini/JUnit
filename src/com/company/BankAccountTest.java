package com.company;

import static org.junit.Assert.*;

/**
 * Created by ac003588 on 9/25/2017.
 */
public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("Executes before any test cases. Count = " + count++); // + count; count++);
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("Tim", "Smith", 1000.00, BankAccount.CHECKING);
        System.out.println("Running test...");
    }
    @org.junit.Test
    public void deposit() throws Exception {
        double balance = account.deposit(200, true);
        assertEquals(1200.00, balance, 0);

    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600, true);
        assertEquals(400.00, account.getBalance(), 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        //double balance = account.withdraw(600, false);
        account.withdraw(600, false);
        fail("Should have thrown an IllegalArgumentException");
       // assertEquals(400.00, balance, 0);

    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception {
        account.deposit(200, true);
        assertEquals(1200.00, account.getBalance(), 0);

    }

    @org.junit.Test
    public void getBalance_withdrawal() throws Exception {
        account.withdraw(200, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
        assertTrue("The account is Not a checking account", account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases (cleanup). Count = " + count++);
    }

    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }




    /* NOTES

    @Before - run before every test (setup at each test)
    @BeforeClass - run before any tests are run (setup once)
    @AfterClass - run after tests (cleanup)

    assertEquals()
    assertNotEquals
    assertNull()
    assertNotNull()
    assertSame()
    assertNotSame()
    assertThat()   - comparse actual value against a matcher (JUnit matcher class)
    assertArrayEquals() - Considers 2 arrays equal when lengths are the same, every element in both arrays are the same, and in the same order
    */

}

