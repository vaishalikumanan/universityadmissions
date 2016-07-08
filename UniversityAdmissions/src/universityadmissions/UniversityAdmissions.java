/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package universityadmissions;

/**
 * February 12th, 2016
 * @author kumav1176
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;

public class UniversityAdmissions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        FileReader applications = new FileReader("Applications.txt");
        Scanner scan = new Scanner(applications);
        
        PrintWriter admissions = new PrintWriter("Admissions.txt");
        
        //ignore titles in txt file
        scan.nextLine();
        
        while(scan.hasNext()){
            
            String last = scan.next() + "\t";
            String first = scan.next() + "\t";
            
            //align results
            if(last.length() < 8){
                last += "\t";
            }
            if(first.length() < 8){
                first += "\t";
            }
            
            String accepted = last + first + "ACCEPTED";
            String rejected = last + first + "REJECTED";
            
            //admission factors
            //Average mark
            int average = scan.nextInt();
            //Essay score
            int essay = scan.nextInt();
            //Number of clubs
            int clubs = scan.nextInt();
            //Number of AP courses
            int ap = scan.nextInt();
            //Did they take Euclid
            String euclid = scan.next();
            //Do they have a job
            String job = scan.next();
            //Volunteer hours
            int volunteer = scan.nextInt();
            
            //conditions for admission
            //Has an average of 90 or more, is a part of 2 clubs or more and 
            //has written the Euclid
            if(average >= 90 && (clubs >= 2 || "yes".equals(euclid))){
                admissions.println(accepted);
            }
            //Has an average of 80 or more, has a job or is a part of 4 or more
            //clubs, has written the Euclid
            else if(average >= 80 && ("yes".equals(job) || clubs >= 4) && 
                    "yes".equals(euclid)){
                admissions.println(accepted);
            }
            //Has an average of 70 or more, has taken 2 or more AP courses, has
            //volunteered at least 200 hours or has a job
            else if(average >= 70 && ap >= 2 && (volunteer >= 200 || 
                    "yes".equals(job))){
                admissions.println(accepted);
            }
            //Has an average of 60 or more, has taken 4 or more AP courses, has
            //an essay score of 5 or has volunteered at least300 hours
            else if(average >= 60 && ap >= 4 && (essay == 5 || volunteer 
                    >= 300)){
                admissions.println(accepted);
            }
            else{
                admissions.println(rejected);
            }
              
        }//close while loop
        
        admissions.close();
        
    }
}
