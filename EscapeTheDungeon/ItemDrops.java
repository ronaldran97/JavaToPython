package edu.cpp.cs.cs141.EscapeTheDungeon;

import edu.cpp.cs.cs141.EscapeTheDungeon.Gun.GunType;

/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #N
 *
 * Developed a version of Escape the Dungeon with 10 steps. Each step has a
 * chance of an encounter where you will fight an enemy.
 *
 * Ronald Tran
 */

/**
 * Created by ronaldtran on 4/21/17.
 *
 * This class represents the different items dropped after and enemy is
 * defeated. Each kind of drop is distinguished using a field value in the class
 * and created using different methods.
 */
public class ItemDrops {

    /**
     * This field represents the datatype ITEMS. Its identifiers are HEALTHPACK
     * and AMMOMAG.
     */
    public enum ITEMS { HEALTHPACK, AMMOMAG }

    /**
     * This field represents ITEMS with variable type
     */
    private ITEMS type;

    /**
     * This is a constructor of this class.
     * @param type parameter
     */
    public ItemDrops(ITEMS type) {
        this.type = type;
    }


    /**
     * This method sets the amount of additional health available after the
     * HEALTHPACK is dropped. The health points available are 5 per drop
     *
     * @return the healthItem that allows the player additional health after
     surviving an encounter.
     */
    public int additionalHealth() {
        int healthItem = 5;
        return healthItem;
    }

    /**
     * This method sets the amount of additional ammo available after the
     * AMMOMAG is dropped.
     *
     * @param type  parameter The type of Gun chosen from datatype GunType.
     *
     * @return The additionalAmmo that allows the player additional ammo after
     * surviving the encounter. The ammo will replenish the ammo to its max
     * amount.
     */
    public int additionalAmmo(GunType type) {
        int additionalAmmo = 0;
        switch (type) {
            case PISTOL:
                additionalAmmo = 15;
                break;
            case RIFLE:
                additionalAmmo = 10;
                break;
            case SHOTGUN:
                additionalAmmo = 5;
        }
        return additionalAmmo;

    }
}
