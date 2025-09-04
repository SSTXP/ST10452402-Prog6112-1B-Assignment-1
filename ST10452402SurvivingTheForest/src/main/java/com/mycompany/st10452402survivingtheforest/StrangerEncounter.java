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
public class StrangerEncounter extends Encounter{

    public StrangerEncounter() {
        super("You meet a stranger.", false);
    }
    
    @Override
    public void trigger(Player player) {
        Random rand = new Random();
        int roll = rand.nextInt(100);

        if (roll < 40) {
            // Friendly stranger
            if (player.getHearts() < 7) {
                System.out.println("You stumble upon a weathered man sitting by a small campfire." +
                                   "He looks up, his tired eyes softening as he gestures for you to sit." +
                                   "He shares some dried meat and clean water with you." +
                                   "Your strength is restored. You gain 1 heart.");
                description = "Friendly stranger (helpful)";
                player.gainHeart(1);
                
            } else {
                System.out.println("You stumble upon a weathered man sitting by a small campfire." +
                                   "He offers you some dried meat and clean water, but you politely decline." +
                                   "You already feel strong enough, so you simply rest for a while before moving on.");
                description = "Friendly stranger (no effect)";
            }

        } else if (roll < 75) {
            // Neutral stranger
            System.out.println("You hear a soft humming and find a cloaked stranger leaning against a tree." +
                               "He speaks in riddles about the forest, then vanishes into the mist without warning." +
                               "You’re left puzzled, but unharmed.");
            description = "Mysterious stranger (no effect)";

        } else {
            // Hostile stranger
            System.out.println("A figure emerges suddenly from the shadows — a stranger with wild eyes and a sharpened stick." +
                               "He lunges at you in desperation, trying to steal what little you have." +
                               "You manage to push him away, but not before suffering a painful wound." +
                               "You lose 1 heart.");
            description = "Hostile stranger (attacked)";
            player.loseHeart(1);
        }

        //Always log the encounter
        player.addEncounter(description);
    }
}    