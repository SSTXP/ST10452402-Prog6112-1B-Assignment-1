/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10452402survivingtheforest;
import java.util.Random;
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
public class Utils {
    
    private static Random rand = new Random();

  public static Encounter generateEncounter(int day) {
    int roll = rand.nextInt(100); // 0-99

    if (roll < 30) {
        // Nothing happens
        System.out.println("You move cautiously. The forest is quiet... for now.");
        return null;
    } else if (roll < 55) {
        return new AnimalEncounter();
    } else if (roll < 60) {
        return new FoodEncounter();
    } else if (roll < 70) {
        return new LakeEncounter();
    } else if (roll < 80) {
        return new StrangerEncounter();
    } else {
        //3% chance for the road
        if (rand.nextInt(100) < 3) {
            return new RoadEncounter();
        } else {
            System.out.println("You push deeper into the forest. The trees close in around you.");
            return null;
        }
    }
}


    public static String getDirection(Scanner sc) {
        while (true) {
            System.out.print("Choose a direction North/South/East/West (Enter corresponding key: N/S/E/W): ");
            String dir = sc.nextLine().trim().toUpperCase();
            if (dir.equals("N") || dir.equals("S") || dir.equals("E") || dir.equals("W")) return dir;
            System.out.println("Invalid input! Please enter N, S, E, or W.");
        }
    }

    public static String randomNightDeath() {
        String[] messages = {
            "The night closes in, and the forest swallows your last breath.",
            "Darkness falls, and the forest takes your soul.",
            "The cries of the forest echo as night claims you."
        };
        return messages[rand.nextInt(messages.length)];
    }

    public static String forestMadness() {
        String[] messages = {
            "The forest breaks your will to survive. You wander endlessly until your mind is consumed.",
            "Three nights have passed. The forest has taken your sanity, and you are lost forever."
        };
        return messages[rand.nextInt(messages.length)];
    }
}