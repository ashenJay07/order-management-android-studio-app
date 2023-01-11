package com.example.ordermanagement;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() {

        // Testing if insert is working properly
        DBOrder dbOrder = null;
        
        dbOrder.placeNewOrder("Cement", 34, 3500.00, 119000.00, "NIBM campus", "684 Malabe", "17-12-2022", "Approved");

        assertEquals(true, dbOrder);
    }

}
