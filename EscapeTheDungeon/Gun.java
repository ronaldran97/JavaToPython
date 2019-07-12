package edu.cpp.cs.cs141.EscapeTheDungeon;

import java.util.Random;

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
 * This class represents the gun objects that you may choose from and the
 * attributes that are associated with each gun.
 * Associated with a gun is its max ammo capacity, amount of current ammo,
 * accuracy, and the gun's damage.
 */
public class Gun {

    /**
     * This field represents the datatype GunType. The identifiers are PISTOL,
     * RIFLE, AND SHOTGUN.
     *
     */
    public enum GunType { PISTOL, RIFLE, SHOTGUN }

    /**
     * This field represents a type of gun from GunType. "type" is the variable
     * that will be used for an identifier of GunType.
     */
    private GunType type;

    /**
     * This field represents the max ammo capacity is for a gun. The amount
     * is set for each gun by the method getMaxAmmo. After an amount is set,
     * it cannot be changed.
     */
    private int maxAmmo;

    /**
     * This field represents ammo amount of gun.
     */
    private int ammo;

    /**
     * This field represents the accuracy of a gun. The accuracy is set for
     * each gun by the method getAccuracy. After an accuracy is set, it cannot be
     * changed.
     */
    private int accuracy;

    /**
     * This field represents the damage of a gun. The damage is et for each gun
     * by the method getDammage. After the damage is set, it cannot be changed.
     */
    private int wDamage;

    /**
     * This method is a constructor that allows setting initial values for type,
     * maxAmmo, wDamage, accuracy, and ammo.
     *
     * @param type : the identifier chosen from datatype GunType
     */
    public Gun(GunType type) {
        this.type = type;
        maxAmmo = getMaxAmmo(type);
        wDamage = getDamage(type);
        accuracy = getAccuracy(type);
        ammo = maxAmmo;
    }

    /**
     * This method assigns the max amount of ammo for each gun. If the gun
     * chosenis a pistol the maximum amount of ammo is 15, if rifle the max
     * amount is 10, and if shotgun the max amount is 5.
     *
     * @param type : The gun chosen from datatype GunType.
     *
     * @return maxAmmo of the weapon chosen.
     */
    public int getMaxAmmo(GunType type) {
        int maxAmmo = 0;
        switch(type) {
            case PISTOL:
                maxAmmo = 15;
                break;
            case RIFLE:
                maxAmmo = 10;
                break;
            case SHOTGUN:
                maxAmmo = 5;
                break;
        }
        return maxAmmo;
    }

    /**
     * This method assigns the accuracy of a gun to its type. The accuracy for
     * pistol is 75%, rifle, 65%, and shotgun 40%.
     *
     * @param type type of gun
     *
     * @return accuracy of the weapon chosen.
     */
    private int getAccuracy(GunType type) {
        int accuracy = 0;
        switch(type) {
            case PISTOL:
                accuracy = 75;
                break;
            case RIFLE:
                accuracy = 65;
                break;
            case SHOTGUN:
                accuracy = 40;
                break;
        }
        return accuracy;
    }

    /**
     * This methood assigns the amount of damage a fun will inflict. The damage
     * for a pistol is 1 hitpoint per shot, rifle is 2 hitpoints per shot, and
     * shotgun is 5 hitpoints per shot.
     *
     * @param type : the gun chosen from datatype GunType.
     *
     * @return damage per weapon.
     */
    private int getDamage(GunType type) {
        int damage = 0;
        switch(type) {
            case PISTOL:
                damage = 1;
                break;
            case RIFLE:
                damage = 2;
                break;
            case SHOTGUN:
                damage = 5;
                break;
        }
        return damage;
    }

    /**
     * This method is what manages the firing of the gun of choice.
     *
     * @return the amount of damage the gun of choice has inflicted after
     shooting it.
     */
    public int shoot() {
        int damage = 0;
        Random random = new Random();
        int chance = random.nextInt(100);
        if(chance < accuracy && ammo > 0) {
            damage = wDamage;
            ammo--;
        }
        return damage;
    }

    /**
     * This method checks which identifier of GunType was chosen.
     *
     * @return the identifier of GunType thas was chosend
     */
    public GunType getGunType() {
        return type;
    }

    /**
     * This method adds ammo to the current gun
     * @param replAmmo The replenished ammo.
     */
    public void addAmmo(int replAmmo){
        ammo += replAmmo;
    }


}
