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
public abstract class Encounter {

    protected String description;
    protected boolean fatal;

    public Encounter(String description, boolean fatal) {
        this.description = description;
        this.fatal = fatal;
    }

    public abstract void trigger(Player player);
    public String getDescription() { return description; }
    public boolean isFatal() { return fatal; }
}
