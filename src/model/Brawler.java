package model;

import java.util.ArrayList;

import view.*;

/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author joseportugal
 * @version May 7, 2025
 */
public abstract class Brawler {
    //~ Fields ................................................................

    //~ Constructors ..........................................................
    public abstract boolean shoot();

    public abstract void draw(int dir, int counter, double angle, int csuper);

    public abstract ArrayList<String> move(int blocksX[], int blocksY[]);

    public abstract boolean isDead();
}
