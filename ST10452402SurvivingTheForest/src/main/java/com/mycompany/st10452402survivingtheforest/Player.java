/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10452402survivingtheforest;
import java.util.ArrayList;
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
public class Player {
    
    private String name;
    private int hearts;
    private int movesLeft;
    private int daysLeft;
    private ArrayList<String> pathHistory;
    private ArrayList<String> encounterHistory;
    private boolean escaped;   

    public Player(String name) {
        this.name = name;
        this.hearts = 7;
        this.movesLeft = 10;
        this.daysLeft = 3;
        this.pathHistory = new ArrayList<>();
        this.encounterHistory = new ArrayList<>();
        this.escaped = false;  
    }

    public void loseHeart(int n) {
        hearts -= n;
        if (hearts < 0) hearts = 0;
    }

    public void gainHeart(int n) {
        hearts += n;
        if (hearts > 7) hearts = 7;
    }

    public void addMove(String direction) {
        pathHistory.add(direction);
        movesLeft--;
    }

    public void addEncounter(String encounter) {
        encounterHistory.add(encounter);
    }

    public void nextDay() {
        movesLeft = 10;
        daysLeft--;
    }

    public boolean hasEscaped() {
        return escaped;
    }

    public void setEscaped(boolean escaped) {
        this.escaped = escaped;
    }

    
    public int getHearts() { return hearts; }
    public int getMovesLeft() { return movesLeft; }
    public int getDaysLeft() { return daysLeft; }
    public ArrayList<String> getPathHistory() { return pathHistory; }
    public ArrayList<String> getEncounterHistory() { return encounterHistory; }
    public String getName() { return name; }
}