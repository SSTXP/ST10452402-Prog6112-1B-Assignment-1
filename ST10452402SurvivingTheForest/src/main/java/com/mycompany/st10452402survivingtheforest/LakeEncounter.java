/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10452402survivingtheforest;
import java.util.Random;
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
public class LakeEncounter extends Encounter{

    public LakeEncounter() {
        super("You come across a source of water.", false);
    }

   @Override
   public void trigger(Player player) {
        Random rand = new Random();
        int roll = rand.nextInt(100);

        if (player.getHearts() < 7) {
            if (roll < 40) {
                // Lake
                System.out.println("You stumble upon a quiet lake, its surface shimmering under the fading light." +
                                   "Kneeling by the shore, you scoop the cool water into your hands." +
                                   "It refreshes your body and spirit." +
                                   "You gain 1 heart.");
                description = "Lake encounter";
                player.gainHeart(1);

            } else if (roll < 70) {
                // River/Stream
                System.out.println("The sound of rushing water guides you to a narrow stream cutting through the forest." +
                                   "You cup your hands and drink deeply from the flowing current." +
                                   "The icy water clears your mind and restores your strength." +
                                   "You gain 1 heart.");
                description = "River encounter";
                player.gainHeart(1);

            } else {
                // Leaf with rainwater
                System.out.println("After wandering for hours, you notice a large leaf glistening with rainwater." +
                                   "You tilt it carefully, letting the droplets fall into your mouth." +
                                   "Though little, it is enough to give you strength." +
                                   "You gain 1 heart.");
                description = "Rainwater leaf";
                player.gainHeart(1);
            }

        } else {
            // if player already has full hearts
            System.out.println("You find a source of water, but your strength is already full." +
                               "You take a moment to rest before pressing on.");
            description = "Water source (no effect)";
        }

        // Always record the encounter
        player.addEncounter(description);
    } 
}