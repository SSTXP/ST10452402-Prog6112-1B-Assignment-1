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
public class AnimalEncounter extends Encounter{
    
    public AnimalEncounter() {
        super("You encounter an animal!", false);
    }

    @Override
    public void trigger(Player player) {
        Random rand = new Random();
        int roll = rand.nextInt(100);
        
        if (roll < 60) {
            System.out.println("From between the trees, a wolf emerges, its eyes glowing in the dim light." +
                                "It snarls and stalks you cautiously. You try to back away, but it lunges at you!" +
                                "You dodge its sharp teeth, but a scratch across your arm bleeds. You lose 1 heart." +
                                "The wolf retreats into the shadows, leaving only the echo of its growl behind.");
            description = "Wolf encounter";
            player.loseHeart(1);
            
        } else if (roll < 90) {
            System.out.println("A venomous snake slithers silently across your path. " +
                               "You freeze, knowing any sudden movement could provoke it. " +
                               "Before you can react, it strikes your leg! Pain surges through your body. " +
                               "You manage to shake it off, but the bite costs you 1 heart. " +
                               "The snake disappears into the underbrush, leaving a lingering threat.");
            description = "Snake encounter";
            player.loseHeart(1);
            
        } else if (roll < 85) {
            System.out.println("Suddenly, a wild boar bursts from the foliage, tusks glinting in the sunlight. " +
                               "You barely dodge its furious charge, rolling to the side as it crashes past. " +
                               "Though you escape, the force of the encounter leaves you bruised and shaken. You lose 1 heart. " +
                               "The boar snorts and vanishes into the trees.");
            description = "Boar encounter";
            player.loseHeart(1);
            
        } else {
            System.out.println("A massive bear crashes through the forest, its roar echoing like thunder. " +
                               "You try to run, but the bear is too fast. It strikes you with overwhelming force, " +
                               "and you fall to the forest floor, helpless. All your hearts are gone. This is fatal.");
            description = "Bear encounter (fatal)";
            player.loseHeart(player.getHearts()); // all hearts gone
        }
        player.addEncounter(description);
    }
}