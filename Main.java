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
        if(numbers.startsWith("//")){
            String delimiter = Character.toString(numbers.charAt(2));
            numbers = numbers.replace("//"+delimiter+"\n", "");
            numbers = numbers.replace(delimiter, ",");
            for(String s : numbers.split(",|\n")){
                d += Integer.parseInt(s);
            }
            return d;
        }
        for(String s : numbers.split(",|\n")){
            d += Integer.parseInt(s);
        }
        return d;
    }
}