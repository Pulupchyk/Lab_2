package org.kpi.fpm.lab_2;

public class Main{
    public static void main(String[] args) {
        LabTest.test();
    }
    public static int Add(String numbers) {
        int d = 0;
        if(numbers.isEmpty()){
            return d;
        }
        if(!(numbers.contains(","))){
            return Integer.parseInt(numbers);
        }
        else{
            String[] s = numbers.split(",");
            d = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
        }
        return d;
    }
}