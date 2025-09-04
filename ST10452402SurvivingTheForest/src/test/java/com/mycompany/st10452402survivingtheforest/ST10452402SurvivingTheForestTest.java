/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.st10452402survivingtheforest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
public class ST10452402SurvivingTheForestTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("Sohan");
    }
    
    // Player Tests
    
    @Test
    public void testInitialHearts() {
        assertEquals(7, player.getHearts(), "Player should start with 7 hearts");
    }

    @Test
    public void testLoseHeart() {
        player.loseHeart(2);
        assertEquals(5, player.getHearts(), "Player should have 5 hearts after losing 2");
    }

    @Test
    public void testLoseHeartBelowZero() {
        player.loseHeart(10);
        assertEquals(0, player.getHearts(), "Player hearts should not go below 0");
    }

    @Test
    public void testGainHeart() {
        player.loseHeart(3);
        player.gainHeart(2);
        assertEquals(6, player.getHearts(), "Player should have 6 hearts after losing 3 and gaining 2");
    }

    @Test
    public void testGainHeartAboveMax() {
        player.gainHeart(5);
        assertEquals(7, player.getHearts(), "Player hearts should not exceed 7");
    }

    @Test
    public void testMovesLeft() {
        player.addMove("N");
        assertEquals(9, player.getMovesLeft(), "Player should have 9 moves left after 1 move");
    }

    @Test
    public void testPathHistory() {
        player.addMove("E");
        player.addMove("S");
        assertEquals(2, player.getPathHistory().size(), "Path history should have 2 entries");
        assertEquals("E", player.getPathHistory().get(0));
        assertEquals("S", player.getPathHistory().get(1));
    }

    @Test
    public void testDaysLeft() {
        player.nextDay();
        assertEquals(2, player.getDaysLeft(), "After nextDay, player should have 2 days left");
        assertEquals(10, player.getMovesLeft(), "Moves should reset to 10 each day");
    }

    @Test
    public void testEscapeFlag() {
        assertFalse(player.hasEscaped(), "Player should not have escaped initially");
        player.setEscaped(true);
        assertTrue(player.hasEscaped(), "Player should have escaped after setEscaped(true)");
    }


    // Encounter Tests
    @Test
    public void testLakeEncounter() {
        LakeEncounter lake = new LakeEncounter();
        int heartsBefore = player.getHearts();
        lake.trigger(player);
        assertTrue(player.getHearts() >= heartsBefore, "Lake should give at least 0 or +1 heart");
        assertFalse(player.getEncounterHistory().isEmpty(), "Encounter should be recorded");
    }

    @Test
    public void testFoodEncounter() {
        FoodEncounter food = new FoodEncounter();
        int heartsBefore = player.getHearts();
        food.trigger(player);
        assertTrue(player.getHearts() >= 0 && player.getHearts() <= 7, "Hearts should remain between 0 and 7");
        assertFalse(player.getEncounterHistory().isEmpty(), "Encounter should be recorded");
    }

    @Test
    public void testAnimalEncounterDamage() {
        AnimalEncounter animal = new AnimalEncounter();
        int heartsBefore = player.getHearts();
        animal.trigger(player);
        assertTrue(player.getHearts() <= heartsBefore, "Animal encounter may cause damage");
    }

    @Test
    public void testStrangerEncounter() {
        StrangerEncounter stranger = new StrangerEncounter();
        int heartsBefore = player.getHearts();
        stranger.trigger(player);
        assertTrue(player.getHearts() >= 0 && player.getHearts() <= 7, "Stranger encounter may heal, hurt, or have no effect");
        assertFalse(player.getEncounterHistory().isEmpty(), "Encounter should be recorded");
    }

    @Test
    public void testRoadEncounter() {
        RoadEncounter road = new RoadEncounter();
        road.trigger(player);
        assertTrue(player.hasEscaped(), "Player should have escaped after RoadEncounter");
        assertFalse(player.getEncounterHistory().isEmpty(), "Encounter should be recorded");
    }
}