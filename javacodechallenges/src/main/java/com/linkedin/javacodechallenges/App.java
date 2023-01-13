package com.linkedin.javacodechallenges;

import java.util.List;

public class App {
    public static double calculateAverageChangeInvested(List<Double> purchases) {
        double avgChangeInvested=0.0;
        for(double item: purchases){
            avgChangeInvested=avgChangeInvested+(Math.ceil(item)-item);
        }
        if(avgChangeInvested==0){
            return 0;
        }
        return avgChangeInvested/purchases.size();
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
