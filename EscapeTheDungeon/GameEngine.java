package edu.cpp.cs.cs141.EscapeTheDungeon;

import edu.cpp.cs.cs141.EscapeTheDungeon.ActiveAgents.AGENT_TYPE;
import edu.cpp.cs.cs141.EscapeTheDungeon.Gun.GunType;
import edu.cpp.cs.cs141.EscapeTheDungeon.ItemDrops.ITEMS;

import java.util.Random;

import static edu.cpp.cs.cs141.EscapeTheDungeon.Gun.GunType.*;

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
 * This class represents the entity that represents an instance of the game. It
 * keeps track of teh current state of teh game, statistics like the number of
 * hitpoints left, guns of player and enemy, etc.
 */
public class GameEngine {

    /**
     * This field calls to the ActiveAgents class and uses variable player to
     * represent the active agent player.
     */
    private ActiveAgents player;

    /**
     * This field calls to the ActiveAgents class and ues variable enemy to
     * represent the activea agent enemy.
     */
    private ActiveAgents enemy;

    /**
     * This method creates the game instance. The player is spawned and enemy
     * is spawned creating an encounter.
     *
     * @param gt : the identifier chosen or given from datatype GunType.
     */
    public void createGameInstance(GunType gt) {

        player = new ActiveAgents(AGENT_TYPE.PLAYER, new Gun(gt));

    }

    /**
     * This method takes in the scenario if an encounter occurs. Initially an
     * encounter does not occur but there is a 15% of an encounter to occur.
     *
     * @return Whether an encounter occurs or not.
     */
    public boolean ifEncounter() {
        boolean encounterOccurs = false;

        int encounterChance = new Random().nextInt(100) ;

        if (encounterChance >= 85) {
            encounterOccurs = true;
        }
        return encounterOccurs;
    }

    /**
     * This method checks the player and enemies current health
     * @return the health of the player and enemy
     */
    public boolean checkHealth() {
        boolean occur = false;

        if (getPlayerHealth() > 0 && getEnemyHealth() > 0) {
            occur = true;
        }

        return occur;
    }

    /**
     * This method takes in the scenario if an encounter does occur and creates
     * the enocunter. It spawns an enemy with a random gun. The gun is given by
     * calling to method getEnemyWeapon.
     */
    public void createEncounter() {
        System.out.println("Creating encounter...");
        enemy = new ActiveAgents
                (ActiveAgents.AGENT_TYPE.ENEMY, getEnemyWeapon());
    }


    /**
     * This method determines the enemy weapon. The gun is chosen randomly. The
     * chances of guns for the enemy are as follow : 15% for shotgun, 35% for a
     * rifle, and 50% for a pistol.
     *
     * @return The weapon that has been chosen randomly.
     */
    private Gun getEnemyWeapon() {
        int randomGun =(new Random()).nextInt(100);
        Gun resultGun = null;

        if (randomGun >= 85) {
            resultGun = new Gun(SHOTGUN);
        } else if (randomGun >= 50) {
            resultGun = new Gun(RIFLE);
        } else {
            resultGun = new Gun(PISTOL);
        }

        return resultGun;

    }

    /**
     * This method gets the current health of the player by calling to the
     * method getHitPoints in the ActiveAgents class.
     *
     * @return the current health of the player.
     */
    public int getPlayerHealth() {
        return player.getHitPoints();

    }

    /**
     * This method gets the current health of the enemy by calling to the
     * method getHitPoints in the ActiveAgents class.
     *
     * @return The current health of the enemy.
     */
    public int getEnemyHealth() {
        return enemy.getHitPoints();
    }

    /**
     * This method takes in the health of the player and if the health is less
     * than or equal to zero the game is over. Initially the game is not over.
     * @return true
     */
    public boolean gameOver() {
        boolean end = false;
        if (player.getHitPoints() >= 0 && player.getMovement() >= 10) {
             end = true;

        }

        return end;
    }

    /**
     * This method gets the enemy's gun by calling to the method getGunType in
     * the ActiveAgents class.
     *
     * @return The gun of the enemy.
     */
    public GunType getEnemyGunType() {
        return enemy.getGunType();
    }

    /**
     * This method is used if you survive. If you survive two items can drop,
     * either a health pack worth 5 hit points or an ammo mag that returns max
     * ammo. There is a 30% chance of a healthpack dropping and an ammo mag
     * will drop by default if a healthpack is not dropped.
     *
     * @return either a health pack or ammo mag.
     */
    public ItemDrops surviveEncounter() {
        int ammo = 0;
        int randomItem = (new Random()).nextInt(100);
        ItemDrops resultItem = null;

        if (randomItem >= 70) {
            System.out.println("Adding HEALTHPACK");
            resultItem = new ItemDrops(ITEMS.HEALTHPACK);
            player.addHealth(resultItem.additionalHealth());
            System.out.println("Your current health is " + getPlayerHealth());
        } else {
            System.out.println("Adding AMMOMAG");
            resultItem = new ItemDrops(ITEMS.AMMOMAG);
            player.addAmmo(resultItem.additionalAmmo(player.getGunType()));
        }

        return resultItem;
    }

    /**
     * This method allows the player to trade shots with the enemy.
     */
    public void takeTurn() {

        enemy.applyDamage(player.shootWeapon());
        player.applyDamage(enemy.shootWeapon());

    }

    /**
     * This method moves the player to the next step
     */

    public void goForward() {
            player.moveForward();
    }

    /**
     * This method applies the run method from ActiveAgents.
     *
     * @param escape The escape method.
     */
    public void applyrun(int escape) {
        player.run(escape);
    }


    /**
     * this method gets the movements of the player
     * @return the position of the player.
     */
    public int getMovemnt() {
        return player.getMovement();
    }

}
