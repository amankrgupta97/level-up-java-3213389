package com.linkedin.javacodechallenges;
import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothing {

  private static int startingPoints=10;
  private int current=startingPoints;
  private Scanner scanner=new Scanner(System.in);
  private Random random=new Random();
  private boolean isStillPlaying=true;


  public void playGame() {
    welcomeMessage();
    askUserToContinue();

    while(isStillPlaying){
      printTryToDouble();
      if(shouldDouble()){
        doubleCuurent();
        printCongrats();
        askUserToContinue();
      }
      else{
        printLost();
        return;
      }
    }
    printTakeAway();
  }
  private void welcomeMessage(){
    System.out.println("Welcome to the Game!!");
  }

  protected void askUserToContinue(){
    System.out.println("Do You want to Continue?");
    this.isStillPlaying=this.scanner.nextLine().toUpperCase().equals("YES");
  }
  
  protected boolean getIsStillPlaying(){
    return this.isStillPlaying;
  }

  private void printTryToDouble(){
    System.out.println("Let's try to Double it..");
  }

  private void printCongrats(){
    System.out.println("Congrats you now have "+this.current+" points");
  }

  private void printLost(){
    System.out.println("Oh You've lost. No points for you");
  }

  private void printTakeAway(){
    System.out.println("You finish with "+this.current+" points");
  }

  private boolean shouldDouble(){
    return this.random.nextInt(2)==0;
  } 

  private void doubleCuurent(){
    this.current=this.current*2;
  }
}