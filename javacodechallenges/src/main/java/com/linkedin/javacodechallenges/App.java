package com.linkedin.javacodechallenges;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

public class App {
    public static void main(String[] args) {

        List<TicketHolder> ticketHolderList =new ArrayList<>();

        try{
            ticketHolderList.addAll(TicketUtils.importTicketHolder("ticketholders.csv"));
        }catch(IOException|CsvValidationException e){
            System.out.println(e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your Full Name in Ticket??");
        String name=scanner.nextLine();
        Optional<TicketHolder> ticketHolderOpt =TicketUtils.findTicketHolder(ticketHolderList, name);
        if(ticketHolderOpt.isEmpty()){
            System.out.println("Sorry You have not booked Your Ticket...You can't enter in party!!");
            scanner.close();
            return;
        }
        System.out.println("How many are with you in party?");
        int numberInParty=scanner.nextInt();
        scanner.close();
        TicketHolder ticketHolder =ticketHolderOpt.get();
        if(!TicketUtils.processTicket(numberInParty, ticketHolder, ticketHolderList)){
            System.out.println("Not Enough tickets...Can't Enter in party");
            return;
        }
        System.out.println("Enjoy the party");
    }
}
