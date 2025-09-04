/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10452402prog6112assignment1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
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
public class Series {

    //This file manages the functionality of the program
    private List<SeriesModel> seriesList = new ArrayList<>(); // A list for storage
    private Scanner sc = new Scanner(System.in);

    
    //This will capture a new series
    // And check the Age restriction and episode count
    public void captureSeries() {
        System.out.print("Enter the series ID: ");
        String id = sc.nextLine();

        System.out.print("Enter the series name: ");
        String name = sc.nextLine();

        int age = getValidAge();

        int episodes = getValidNumber("Enter the number of episodes for " + name + ": ");

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("\nSeries processed successfully!");
    }

   
    
    private int getValidAge() {
        int age;
        while (true) {
            try {
                System.out.print("Enter the series age restriction: ");
                age = Integer.parseInt(sc.nextLine());

                if (age >= 2 && age <= 18) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect series age!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series age!");
            }
        }
        return age;
    }

    
    
    private int getValidNumber(String message) {
        int num;
        while (true) {
            try {
                System.out.print(message);
                num = Integer.parseInt(sc.nextLine());
                if (num > 0) break;
                else System.out.println("Number must be greater than 0!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number entered!");
            }
        }
        return num;
    }

    
    //Search for serires through ID 
    public void searchSeries() {
        System.out.print("Enter the series ID to search: ");
        String id = sc.nextLine();

        SeriesModel found = findSeriesById(id);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Series with Series ID: " + id + " was not found!");
        }
    }

   
    //Update series information
    public void updateSeries() {
        System.out.print("Enter the series ID to update: ");
        String id = sc.nextLine();

        SeriesModel found = findSeriesById(id);
        if (found != null) {
            System.out.print("Enter the series name: ");
            found.setSeriesName(sc.nextLine());

            found.setSeriesAge(getValidAge());

            found.setNumberOfEpisodes(getValidNumber("Enter the number of episodes: "));

            System.out.println("Series updated successfully!");
        } else {
            System.out.println("Series with Series ID: " + id + " was not found!");
        }
    }

    
    //Delete series 
    public void deleteSeries() {
        System.out.print("Enter the series ID to delete: ");
        String id = sc.nextLine();

        SeriesModel found = findSeriesById(id);
        if (found != null) {
            OUTER:
            while (true) {
            System.out.print("Are you sure you want to delete series " + id + "? Select your choice (y/n): ");
            String confirm = sc.nextLine().trim().toLowerCase();
                switch (confirm) {
                    case "y" -> {
                        seriesList.remove(found);
                        System.out.println("Series with Series ID: " + id + " WAS deleted!");
                        break OUTER; 
                    }
                    case "n" -> {
                        System.out.println("Delete cancelled.");
                        break OUTER; 
                    }
                    default -> System.out.println("Invalid input! Please enter 'y' for yes or 'n' for no.");
                }
            }
        } else {
            System.out.println("Series with Series ID: " + id + " was not found!");
        }
    }


    
    //print a report for all series information
    public void seriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }
        int count = 1;
        for (SeriesModel s : seriesList) {
            System.out.println("\nSeries " + count);
            System.out.println(s);
            count++;
        }
    }

  
    
    
    //Methods for unit testing
    public void captureSeriesForTest(String id, String name, int age, int episodes) {
        seriesList.add(new SeriesModel(id, name, age, episodes));
    }

    public SeriesModel findSeriesByIdForTest(String id) {
        return findSeriesById(id);
    }

    public void updateSeriesForTest(String id, String name, int age, int episodes) {
        SeriesModel s = findSeriesById(id);
        if (s != null) {
            s.setSeriesName(name);
            s.setSeriesAge(age);
            s.setNumberOfEpisodes(episodes);
        }
    }

    public boolean deleteSeriesForTest(String id) {
        SeriesModel s = findSeriesById(id);
        if (s != null) {
            seriesList.remove(s);
            return true;
        }
        return false;
    }

    public boolean isValidAgeForTest(int age) {
        return age >= 2 && age <= 18;
    }


    private SeriesModel findSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) return s;
        }
        return null;
    }
}