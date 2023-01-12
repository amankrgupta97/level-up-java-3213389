package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
                List<String> studentsWithIncompleteVolunteer = new ArrayList<String>();;
                int count=0;
                for(String student :students){
                        for(List<String> eventAttendees:attendeesMapping.values()){
                                for(String attendee:eventAttendees){
                                        if(student.equals(attendee)){
                                                count=count+1;
                                                break;
                                        }
                                }
                                if(count>=2){
                                        break;
                                }
                        }
                        if(count<2){
                                studentsWithIncompleteVolunteer.add(student);
                        }
                        count=0;
                }
        
        return studentsWithIncompleteVolunteer;
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
