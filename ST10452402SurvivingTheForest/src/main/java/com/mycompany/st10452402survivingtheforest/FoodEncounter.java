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
public class FoodEncounter extends Encounter{

    public FoodEncounter() {
        super("You find some food.", false);
    }

    @Override
    public void trigger(Player player) {
        Random rand = new Random();
        int roll = rand.nextInt(100);

        if (roll < 80) {  
            // 80% chance of finding something edible
            if (player.getHearts() < 7) {
                if (roll < 50) {
                    System.out.println("Among the bushes, you spot a cluster of bright red berries." +
                                       "You pick them carefully, testing one before eating more." +
                                       "The sweetness fills you with hope and strength." +
                                       "You gain 1 heart.");
                    description = "Berries found";
                     player.gainHeart(1);

                } else {
                    System.out.println("Near the roots of an old oak, mushrooms grow in thick clusters." +
                                       "You hesitate, but hunger drives you to taste them." +
                                       "They are edible and surprisingly filling." +
                                       "You gain 1 heart.");
                    description = "Mushrooms found";
                    player.gainHeart(1);
                }

                } else {
                    System.out.println("You find food, but you’re already at full strength." +
                                       "You nibble out of habit, but it doesn’t give you any more energy.");
                    description = "Food found (no effect)";
                }

            } else {
                // Poisonous fruit
                System.out.println("You discover a strange, colorful fruit hanging from a low branch." +
                                   "It smells sweet, and you take a cautious bite." +
                                   "Moments later, your stomach twists with sharp pain—it's poisonous!" +
                                   "You lose 1 heart.");
                description = "Poisonous food";
                player.loseHeart(1);
            }

        // Always record the encounter
        player.addEncounter(description);
    }
}