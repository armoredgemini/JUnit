package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by ac003588 on 9/29/2017.
 */
@RunWith(Parameterized.class)
public class BankAccountTestParameterized {
    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Tony", "Smith", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100, true, 1100.00},
                {200, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, false, 2000.00}
        });


    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);

    }
 }
