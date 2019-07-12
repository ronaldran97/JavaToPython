package edu.cpp.cs.cs141.EscapeTheDungeon;

import edu.cpp.cs.cs141.EscapeTheDungeon.Gun.GunType;

/**
 *

 *
 * Developed a version of Escape the Dungeon with 10 steps. Each step has a
 * chance of an encounter where you will fight an enemy.
 *
 * Ronald Tran
 */

/**
 * Created by ronaldtran on 4/21/17.
 *
 * This class represents the active agents of the game. The player and enemy
 * differentiated as different identifiers of datatype AGENT_TYPE. They are
 * created by diferent overloaded constructor methods.
 */
public class ActiveAgents {

    /**
     * This field represents the datatype AGENT_TYPE. The identifiers for this
     * datatype are PLAYER and ENEMY.
     */
    public enum AGENT_TYPE { PLAYER, ENEMY }

    /**
     * This field represents the hitpoints of the player and enemy. The
     * hitPoints are used to keep track of how much has been received or given
     * the current health of the player and enemy.
     */
    private int hitPoints;

    /**
     * This field represents the gun of the active agents.
     */
    private Gun gun;

    /**
     * This field represents the movements of the player. The movements are set
     * in the methods moveForward and moveBackward.
     */
    private int movement;

    /**
     * This field represents the steps which correlate with movement.
     */
    private int steps;

    /**
     * A constructor of ActiveAgents. It allows the setting of initial values
     * for fields gun and hitPoints.
     *
     * @param at : datatype AGENT_TYPE is given the variable at.
     * @param gun : Gun is given variable gun.
     */
    public ActiveAgents(AGENT_TYPE at, Gun gun){
        hitPoints = getHealth(at);
        this.gun = gun;
        movement = 0;

    }

    /**
     * This method represents the health the player and enemy. hitPoints is set
     * to this method to get the health of the player and enemy.
     *
     * @param at : The parameter is set to datatype AGENT_TYPE with variable at.
     *
     * @return The given health of the enemy and player.
     */
    private int getHealth(AGENT_TYPE at) {
        int hp = 0;

        switch(at) {
            case ENEMY:
                hp = 5;
                break;
            case PLAYER:
                hp = 20;
                break;
        }

        return hp;
    }

    /**
     * This method allows the player and enemy to shoot their guns. It calls to
     * the shoot method in the gun class.
     *
     * @return The hitPoints given and received based on the shoot method in
     * the gun class
     */
    public int shootWeapon() {
        return gun.shoot();
    }

    /**
     * This method applies the damage to the health of the Active Agent after
     * each turn of the encounter
     * @param dmg parameter damage
     */
    public void applyDamage(int dmg) {
        if (hitPoints > dmg) {
            hitPoints -= dmg;
        } else {
            hitPoints = 0;
        }

    }

    /**
     * This method gets the hitPoints. It tells the current health of the
     * active agents.
     *
     * @return the current state of the identifer hitPoints.
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * This method gets the gun that the active agents have chosen or received.
     *
     * @return the gun type that is being wielded.
     */
    public GunType getGunType() {
        return gun.getGunType();
    }

    /**
     * This method gets the movements of the player.
     *
     * @return the movements of the player
     */
    public int getMovement() {
        return movement;
    }

    /**
     * This method increases the position of the player forward. It is set to
     * movement and returns movement as the new postion.
     *
     * @return The new position of the player.
     */
    public int moveForward() {
        if(movement != 10) {
            movement++;
        }
        return movement;
    }

    /**
     * This method decreases the position of the player. It is set to movement
     * and returns the movement as the new postion.
     *
     * @return The new position of the player.
     */
    public int moveBackwards() {
        --movement;
        System.out.println("You are now at " + movement);
        return movement;
    }

    /**
     * This method represents the players choice to run. The chance of escaping
     * is 10%. If the position of the player is greater than where they started
     * and they player escapes, his position will be moved backwards.
     * @param escapeChance : HEALTHPACK escape parameter
     */
    public void run(int escapeChance) {
        int escape = 10;
        movement = 0;

        System.out.println("Running");
        if ( movement > 0 ) {

            if ( escape > escapeChance ) {
                moveBackwards();
            }
        }
    }

    /**
     * This method adds health to the current health
     * @param replHealth the new amount of health
     */
    public void addHealth(int replHealth) {
        hitPoints += replHealth;

    }

    /**
     * This method adds max ammo to the current gun.
     * @param replAmmo new amount of ammo to gun
     */
    public void addAmmo(int replAmmo) {
        gun.addAmmo(replAmmo);
    }

}
