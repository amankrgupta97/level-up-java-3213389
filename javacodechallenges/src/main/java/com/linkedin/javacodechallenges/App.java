package com.linkedin.javacodechallenges;

import java.util.Scanner;
import java.lang.Math;

public class App {

    public static double calculateWaterBill(double gallonsUsage) {
        int gallonsPerCcf=748;
        final double COST_PER_2CCF =18.84;
        final double COST_PER_ADD_CCF=3.90;
        double bill=0.0;
        if(gallonsUsage>(2*gallonsPerCcf)){

            double additonalGallonUsage=(gallonsUsage-2*gallonsPerCcf)/gallonsPerCcf;

            if(Math.round(additonalGallonUsage)-additonalGallonUsage < 0){
                additonalGallonUsage=Math.round(additonalGallonUsage)+1;
            }
            else{
                additonalGallonUsage=Math.round(additonalGallonUsage);
            }
            bill=COST_PER_2CCF+additonalGallonUsage*COST_PER_ADD_CCF;
            return bill;
        }
        return COST_PER_2CCF;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
