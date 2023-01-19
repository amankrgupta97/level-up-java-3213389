package com.linkedin.javacodechallenges;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TicketUtils {
  public static List<TicketHolder> importTicketHolder(String filename) throws CsvValidationException, IOException{
    List<TicketHolder> ticketHolderList = new ArrayList<>();
    if(!filename.contains(".csv")){
      System.out.println("This file is not a csv file!");
      return ticketHolderList; 
    }

    FileInputStream fileInputStream = new FileInputStream(filename);
    InputStreamReader reader = new InputStreamReader(fileInputStream,StandardCharsets.UTF_8);
    CSVReader csvReader = new CSVReader(reader);
    csvReader.readNext();
    String row[];

    while((row=csvReader.readNext())!=null){
      ticketHolderList.add(new TicketHolder(row[0],Integer.parseInt(row[1])));
    }
    csvReader.close();
    return ticketHolderList;    
  }

  public static Optional<TicketHolder> findTicketHolder(List<TicketHolder> ticketHolderList,String name){
    return ticketHolderList.stream().filter(ticketholder -> ticketholder.getName().equalsIgnoreCase(name)).findFirst();
  }

  public static boolean processTicket(int numberInParty,TicketHolder ticketHolder,List<TicketHolder> ticketHolderList){

    int remaining = ticketHolder.getQuantity()-numberInParty;
    if(remaining<0){
      System.out.println("Less number of tickets purchased");
      return false;
    }

    if(remaining!=0){
      System.out.println("Less number of people in party...Keeping Remaining in list");
      ticketHolder.setQuantity(remaining);
      return true;
    }
    ticketHolderList.remove(ticketHolder);
    return true;
  }
}
