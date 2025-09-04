/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10452402survivingtheforest;
import java.util.Scanner;
/**
 *
 * @author sohan
 * Student Number: ST10452402    
 * Name and Surname: Sohan Seeth    
 * Module: PROG6112 
 * Module Code: Programming 1B
 * Assessment Type: Assignment 1
 * Lecturer Name: Ms. Dharshanee Moodley
 * 
 * Students often get bored while waiting for classes or when taking breaks. 
 * They need a simple, fun game that runs in the console to pass time without needing the internet.
 * The game uses arrays to track the player’s path and encounters,
 * loops to manage turns and repeated actions,
 * inheritance to define different types of encounters (animals, food, lakes, strangers, and the road)
 */
public class ST10452402SurvivingTheForest {

    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        System.out.println("=== SURVIVING THE FOREST ===");
        System.out.print("Enter your name, survivor: ");
        String name = sc.nextLine();
        Player player = new Player(name);

        System.out.println("\nWelcome, " + player.getName() + ". Your journey begins now...\n");
        System.out.println("You awake to the sound of cracking wood and rushing wind. Your airplane has crashed deep within an uncharted forest.");
        System.out.println("The wreckage is scattered, and the faint glow of the setting sun casts long shadows between the trees.");
        System.out.println("Miraculously, you are alive, but you have nothing but a compass to guide your way.");
        System.out.println("Your goal: find a road that leads out of this wilderness before nightfall, survive the dangers of the forest, and escape.");
        System.out.println("You have 7 hearts representing your life force. Each dangerous encounter will cost you hearts, while finding food or water can restore them.");
        System.out.println("Each day gives you 10 moves to navigate through the forest. Make your choices wisely — one wrong move could be fatal.");
        System.out.println("The forest is full of surprises: wild animals, strange strangers, hidden lakes, and treacherous paths. Will you survive?\n");
        System.out.println("Your adventure begins now...");


        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("\nHearts: " + player.getHearts() + " | Moves left today: " + player.getMovesLeft() + " | Days left: " + player.getDaysLeft());
            String direction = Utils.getDirection(sc);
            player.addMove(direction);

            Encounter encounter = Utils.generateEncounter(3 - player.getDaysLeft());
            if (encounter != null) encounter.trigger(player);

            // Check victory
            if (encounter instanceof RoadEncounter) {
                gameOver = true;
                break;
            }

            // Check fatal / hearts
            if (player.getHearts() <= 0) {
                System.out.println("You have no hearts left. You died.");
                gameOver = true;
                break;
            }

            // Check nightfall
            if (player.getMovesLeft() == 0) {
                if (player.getHearts() == 7 && player.getDaysLeft() > 1) {
                    System.out.println("You survived the night with full hearts! Hearts reset to 2.");
                    player.nextDay();
                    player.loseHeart(5); // reset to 2 hearts
                } else if (player.getDaysLeft() == 1 && player.getHearts() == 7) {
                    System.out.println("You survived the night! Hearts reset to 2.");
                    player.nextDay();
                    player.loseHeart(5);
                } else if (player.getDaysLeft() > 1) {
                    System.out.println(Utils.randomNightDeath());
                    gameOver = true;
                    break;
                } else {
                    System.out.println(Utils.forestMadness());
                    gameOver = true;
                    break;
                }
            }
        }

        // Final Report
        System.out.println("\n=== GAME REPORT ===");
        System.out.println("Survivor: " + player.getName());
        System.out.println("Days Survived: " + (3 - player.getDaysLeft()));
        System.out.println("Path Taken: " + String.join(" → ", player.getPathHistory()));
        System.out.println("Encounters: " + String.join(", ", player.getEncounterHistory()));
        System.out.println("Hearts Left: " + player.getHearts());
        System.out.println("Your path through the forest was harsh and unpredictable. Each choice shaped your fate, and the forest now holds the story of your survival...");
        sc.close();
    }
}

/*
JUnit. (n.d.) JUnit 5 User Guide. Available at: https://junit.org/junit5/docs/current/user-guide/ (Accessed: 3 September 2025).

IIEVC School of Computer Science, 2022. Link your local repository (NetBeans folder) with your GitHub repo. [video online] Available at: https://youtu.be/M9DzeAw3uMY?si=08PiED3nAYkcM9Vo [Accessed 21 April 2025].

IIEVC School of Computer Science, 2022. Add junit5 jar files. [video online] Available at: https://youtu.be/fQaUsfEzGdw?si=JX4uSEFqpayJUVSM [Accessed 3 September 2025].

IIEVC School of Computer Science, 2022. Create and run your first unit test. [video online] Available at: https://youtu.be/1Pa15vDWG-8?si=UlkhpNblwGAnkMvs [Accessed 3 September 2025].

IIEVC School of Computer Science, 2022. Push your code to GitHub. [video online] Available at: https://youtu.be/SqHkWHtmMJo?si=LL9E7Li1isq1Y2Xq [Accessed 3 September 2025].

IIEVC School of Computer Science, 2022. Automate your unit tests. [video online] Available at: https://youtu.be/dWbDN7lxWu4?si=2j3DlIEyqOoEAR84 [Accessed 3 September 2025].
*/