/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10452402prog6112assignment1;
import java.util.Scanner;
/**
 *
 * @author sohan
 * 
 * Student Number: ST10452402    
 * Name and Surname: Sohan Seeth    
 * Module: PROG6112 
 * Module Code: Programming 1B
 * Assessment Type: Assignment 1
 * Lecturer Name: Ms. Dharshanee Moodley
 */

// Displays the starting menu to the user , which allows for: Capturing, searching, updating, deleting, and printing a series report.


public class ST10452402PROG6112Assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Series manager = new Series();
        
        // User welcoming screen 
        System.out.println("Welcome to Latest Series 2025!");                   
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String launchChoice = sc.nextLine();

        //Exits the application if user enters any key besides (1)
        if (!launchChoice.equals("1")) {                                        
            System.out.println("Exiting application. Goodbye!");
            return;
        }

        //Main menu
        while (true) {
            System.out.println("\n---------------LATEST SERIES 2025---------------");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report 2025.");
            System.out.println("(6) Exit Application.");
            System.out.println("-------------------------------------------------");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            //According to user input this will call the corrisponding series method 
            switch (choice) {
                case "1": manager.captureSeries(); break;
                case "2": manager.searchSeries(); break;
                case "3": manager.updateSeries(); break;
                case "4": manager.deleteSeries(); break;
                case "5": manager.seriesReport(); break;
                case "6": 
                    System.out.println("Exiting... Goodbye!");
                    return;
                default: 
                    System.out.println("Invalid option. Select from options 1-6");//Error message 
                    break;
            }
        }
    }
}

/*
JUnit. (n.d.) JUnit 5 User Guide. Available at: https://junit.org/junit5/docs/current/user-guide/ (Accessed: 3 September 2025).

IIEVC School of Computer Science, 2022. Link your local repository (NetBeans folder) with your GitHub repo. [video online] Available at: https://youtu.be/M9DzeAw3uMY?si=08PiED3nAYkcM9Vo [Accessed 21 April 2025].

IIEVC School of Computer Science, 2022. Add junit5 jar files. [video online] Available at: https://youtu.be/fQaUsfEzGdw?si=JX4uSEFqpayJUVSM [Accessed 3 September 2025].

IIEVC School of Computer Science, 2022. Create and run your first unit test. [video online] Available at: https://youtu.be/1Pa15vDWG-8?si=UlkhpNblwGAnkMvs [Accessed 3 September 2025].

IIEVC School of Computer Science, 2022. Push your code to GitHub. [video online] Available at: https://youtu.be/SqHkWHtmMJo?si=LL9E7Li1isq1Y2Xq [Accessed 3 September 2025].

IIEVC School of Computer Science, 2022. Automate your unit tests. [video online] Available at: https://youtu.be/dWbDN7lxWu4?si=2j3DlIEyqOoEAR84 [Accessed 3 September 2025].
*/