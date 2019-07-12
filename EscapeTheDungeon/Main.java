package edu.cpp.cs.cs141.EscapeTheDungeon;

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
 * this class is where teh program is launched from.
 */
public class Main {
    /**
     * This is the main
     * @param args the argument
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        GameEngine ge = new GameEngine();

        ui.gameStart();

    }
}
