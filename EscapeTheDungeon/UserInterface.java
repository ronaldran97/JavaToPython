package edu.cpp.cs.cs141.EscapeTheDungeon;

import edu.cpp.cs.cs141.EscapeTheDungeon.Gun.GunType;
import edu.cpp.cs.cs141.EscapeTheDungeon.ItemDrops.ITEMS;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Developed a version of Escape the Dungeon with 10 steps. Each step has a
 * chance of an encounter where you will fight an enemy.
 *
 * Ronald Tran
 */

/**
 * Created by ronaldtran on 4/21/17.
 *
 * This class is in charge of the interactive parts of the program. It displays
 * the information and obtains the input of the player.
 */
public class UserInterface {

    /**
     * This field calls to the GameEngine class and it is represented by the
     * variable ge.
     */
    private GameEngine ge;

    /**
     * This field calls the Scanner and it is represented by the variable sc.
     */
    private Scanner sc;

    /**
     * A constructor that sets the initial values for ge and sc.
     */
    public UserInterface() {
        ge = new GameEngine();
        sc = new Scanner(System.in);
    }

    /**
     * This method starts the game. It will either start the game for quit the
     * gane depending on the user's input.
     */
    public void gameStart() {
        int option;
        while ((option = getUserOption()) != 2) {
            switch(option) {
                case 1:
                    runGameLoop();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }

    /**
     * This method runs the game. It gets the users gun type and creates a game
     * instance by calling to teh GameEngine class. In the encounter if your
     * health is greater than 0 and your enemy's health is at 0 than you
     * survive, otherwise you lose.
     */
    public void runGameLoop() {
        GunType gt = getUserGunType();
        ge.createGameInstance(gt);
        int chanceOfDrop = new Random().nextInt(100);
        ITEMS survive = null;

        while(!ge.gameOver()) {

            System.out.println
                    ("Press ENTER to move forward " + ge.getMovemnt());
            sc.nextLine();
            ge.goForward();

            if (ge.ifEncounter()) {
                ge.createEncounter();

                while (ge.checkHealth()) {
                    gameLoop();
                }

                if (ge.getPlayerHealth() > 0 && ge.getEnemyHealth() <= 0) {
                    System.out.println("You survived!");
                    ItemDrops reward = ge.surviveEncounter();

                } else if
                        (ge.getPlayerHealth() <= 0 && ge.getEnemyHealth() >= 0) {
                    System.out.println("You lose");
                }

            }
        }
    }

    /**
     * This method takes the players input on whether to run or shoot from an
     * encounter.
     *
     * @param choice the choice of the player
     */
    public void encounterInput(int choice) {
        int random = new Random().nextInt(100);
        if(choice == 1) {
            ge.takeTurn();
        } else if (choice == 2){
            ge.applyrun(random);
        }
    }

    /**
     *This method performs the encounter.
     *
     *return : true or false
     */
    public void gameLoop() {
        String enemyGun = getEnemyGunName();

        System.out.println("An enemy with a " + enemyGun + " has spawned!");
        System.out.println("Press 1 to shoot");
        System.out.println("Press 2 to run");
        int option = sc.nextInt();

        encounterInput(option);

        ge.takeTurn();

        System.out.println("Your current health is " + ge.getPlayerHealth());
        System.out.println
                ("Your enemy's current health is " + ge.getEnemyHealth());

    }

    /**
     * This method gets the enemy's gun and displays its name.
     *
     * @return the enemy's gun name.
     */
    public String getEnemyGunName() {
        String gunName = " ";
        GunType gt = ge.getEnemyGunType();

        switch (gt) {
            case PISTOL:
                gunName = "Pistol";
                break;
            case RIFLE:
                gunName = "Rifle";
                break;
            case SHOTGUN:
                gunName = "Shotgun";
                break;
        }

        return gunName;
    }

    /**
     * This method gets the player's gun type
     *
     * @return the players gun type
     */
    public GunType getUserGunType() {
        GunType gt = null;
        gt = gunSelectionMenu();
        return gt;
    }

    /**
     * This method is the menu of guns for the player to choose from
     * @return the chosen gun of the player
     */
    public GunType gunSelectionMenu() {
        GunType gt = GunType.PISTOL;
        System.out.println("Select your type of weapon: ");
        System.out.println(" 1. Pistol");
        System.out.println(" 2. Rifle");
        System.out.println(" 3. Shotgun");
        int selection = sc.nextInt();
        sc.nextLine();

        switch (selection) {
            case 1:
                gt = GunType.PISTOL;
                break;
            case 2:
                gt = GunType.RIFLE;
                break;
            case 3:
                gt = GunType.SHOTGUN;
                break;
            default:
                System.out.println("Invalid selection!" +
                        " Pistol selected by default");
        }

        return gt;
    }

    /**
     * This method determins what the player wants to do in the main menu.
     *
     * @return the option that the player has chosen.
     */
    public int getUserOption() {
        int option;
        System.out.println("****************************************");
        System.out.println("Welcome to Random Encounter 1.0!");
        System.out.println("\n Select from the following option:");
        System.out.println("\n  1. New Game");
        System.out.println("  2. Quit");
        option = sc.nextInt();
        sc.nextLine();
        return option;
    }
}
