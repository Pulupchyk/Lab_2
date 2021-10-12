package org.kpi.fpm.lab_2;

public class Main{
    public static void main(String[] args) {
        LabTest.test();
    }
    public static int Add(String numbers) {
        int d = 0;
        if(numbers.isEmpty()){
            return 0;
        }
        for(String s : numbers.split(",")){
            d += Integer.parseInt(s);
        }
        return d;
    }
}