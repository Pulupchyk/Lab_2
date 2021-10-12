package org.kpi.fpm.lab_2;

import static org.junit.Assert.*;

public class LabTest {
    public static void test(){
        first_step_test();
        second_step_test();
    }
    public static void first_step_test(){
        assertEquals(0, Main.Add(""));
        assertEquals(1, Main.Add("1"));
        assertEquals(3, Main.Add("1,2"));
    }
    public static void second_step_test(){
        assertEquals(28, Main.Add("1,2,3,4,5,6,7"));
    }
}
