/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10452402survivingtheforest;

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
public class RoadEncounter extends Encounter{

    public RoadEncounter() {
        super("You find the road!", false);
    }

    @Override
    public void trigger(Player player) {
        System.out.println("As you push through the thick underbrush, your foot suddenly hits gravel instead of soil." +
                           "The trees thin out, and before you stretches a cracked, weather-beaten road." +
                           "Relief surges through your chest — you’ve finally found a way out of the endless forest." +
                           "Somewhere along this road, help will come." +
                           "\n" +
                           "Congratulations, " + player.getName() + "! You survived the forest.");
        description = "Found the road (escaped!)";

    //end-game
    player.addEncounter(description);
    player.setEscaped(true);
    }
}