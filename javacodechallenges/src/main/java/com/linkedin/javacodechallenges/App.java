package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static boolean isPasswordComplex(String password) {
        if(password.length()<6){
            return false;
        }
        boolean hasUpperCase=false;
        boolean hasLowerCase=false;
        boolean hasDigit=false;
        for(int i=0;i<password.length() || !hasUpperCase && !hasLowerCase && !hasDigit;i++){
            Character current=password.charAt(i);
            if(Character.isDigit(current)){
                hasDigit=true;
            }else if(Character.isUpperCase(current)){
                hasUpperCase=true;
            }else if(Character.isLowerCase(current)){
                hasLowerCase=true;
            }
        }
        return hasDigit && hasUpperCase && hasLowerCase;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? "
                + isPasswordComplex(userInput));

        scanner.close();
    }
}
