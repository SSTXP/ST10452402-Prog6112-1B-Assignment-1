/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10452402prog6112assignment1;

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
public class SeriesModel {

    //Contains ID, name, age restriction, and number of episodes.
    //Provides getters and setters
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int numberOfEpisodes;

    
    public SeriesModel(String seriesId, String seriesName, int seriesAge, int numberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.numberOfEpisodes = numberOfEpisodes;
    }

    //getters 
    public String getSeriesId() { return seriesId; }
    public String getSeriesName() { return seriesName; }
    public int getSeriesAge() { return seriesAge; }
    public int getNumberOfEpisodes() { return numberOfEpisodes; }

    //setters
    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }
    public void setSeriesAge(int seriesAge) { this.seriesAge = seriesAge; }
    public void setNumberOfEpisodes(int numberOfEpisodes) { this.numberOfEpisodes = numberOfEpisodes; }

   
    
    @Override
    public String toString() {
        return "\nSERIES ID: " + seriesId +
               "\nSERIES NAME: " + seriesName +
               "\nSERIES AGE RESTRICTION: " + seriesAge +
               "\nNUMBER OF EPISODES: " + numberOfEpisodes;
    }
}    