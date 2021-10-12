package org.kpi.fpm.lab_2;

import static org.junit.Assert.*;

public class LabTest {
    public static void test(){
        first_step_test();
        second_step_test();
        third_test_step();
        forth_step_test();
        fifth_step_test();
        sixth_step_test();
        seventh_step_test();
    }

    public static void first_step_test(){
        assertEquals(0, Main.Add(""));
        assertEquals(1, Main.Add("1"));
        assertEquals(3, Main.Add("1,2"));
    }
    public static void second_step_test(){
        assertEquals(28, Main.Add("1,2,3,4,5,6,7"));
    }
    public static void third_test_step(){
        assertEquals(6, Main.Add("1\n2,3"));
    }
    public static void forth_step_test(){
        assertEquals(3, Main.Add("//;\n1;2"));
    }
    public static void fifth_step_test(){
        try{
            Main.Add("//*\n-1*2*-3");
        }catch (RuntimeException ex) {
            assertEquals("negatives not allowed: -1 -3", ex.getMessage());
            //System.out.println(ex.getMessage());
        }
    }
    public static void sixth_step_test() {
        assertEquals(2, Main.Add("2,1001"));
    }
    public static void seventh_step_test(){
        assertEquals(6, Main.Add("//[***]\n1***2***3"));
    }

}
