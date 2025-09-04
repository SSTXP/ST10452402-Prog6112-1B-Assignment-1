/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.st10452402prog6112assignment1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
public class ST10452402PROG6112Assignment1Test {
    
    //Unit testing for the Series class
    private Series manager;

    //Setup before each test.
    @BeforeEach
    void setUp() {
        manager = new Series();
        manager.captureSeriesForTest("101", "Extreme Sports", 12, 10);
    }

    @Test
    void testSearchSeries() {
        SeriesModel found = manager.findSeriesByIdForTest("101");
        assertNotNull(found);
        assertEquals("Extreme Sports", found.getSeriesName());
    }

    @Test
    void testSearchSeries_SeriesNotFound() {
        assertNull(manager.findSeriesByIdForTest("999"));
    }

    @Test
    void testUpdateSeries() {
        manager.updateSeriesForTest("101", "Extreme Sports 2025", 10, 12);
        SeriesModel updated = manager.findSeriesByIdForTest("101");
        assertNotNull(updated);
        assertEquals("Extreme Sports 2025", updated.getSeriesName());
        assertEquals(10, updated.getSeriesAge());
        assertEquals(12, updated.getNumberOfEpisodes());
    }

    @Test
    void testDeleteSeries() {
        assertTrue(manager.deleteSeriesForTest("101"));
        assertNull(manager.findSeriesByIdForTest("101"));
    }

    @Test
    void testDeleteSeries_SeriesNotFound() {
        assertFalse(manager.deleteSeriesForTest("999"));
    }

    @Test
    void testSeriesAgeRestriction_AgeValid() {
        assertTrue(manager.isValidAgeForTest(12));
    }

    @Test
    void testSeriesAgeRestriction_AgeInvalid() {
        assertFalse(manager.isValidAgeForTest(32));
    }
}