package model;

import java.math.*;

import view.*;
import view.Window.out;

/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author joseportugal
 * @version May 7, 2025
 */
public class ColtSuper extends Bullet {

    int x;

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the direction
     */
    public double getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }
    int y;
    int speed;
    String color;
    double direction;

    public ColtSuper(int x, int y, double direction) {
        super(x, y);
        this.x = x + 50;
        this.y = y + 50;
        this.direction = direction;
        speed = 30;
        color = "blue";
    }

    public void draw(double angle) {
        Window.out.color("white");
        Window.out.rectangle((int) (x + ((50 * Math.cos(2 * Math.PI * (angle / 360))))), (int) (y - (50 * Math.sin(2 * Math.PI * (angle / 360)))), 20, 12, 360 - angle);
        Window.out.circle((int) (x + (((60 * Math.cos(2 * Math.PI * (angle / 360)))))), (int) (y - (60 * Math.sin(2 * Math.PI * (angle / 360)))), 6);
        // smaller blue bullet
        Window.out.color("green");
        Window.out.rectangle((int) (x + ((50 * Math.cos(2 * Math.PI * (angle / 360))))), (int) (y - (50 * Math.sin(2 * Math.PI * (angle / 360)))), 20, 10, 360 - angle);
        Window.out.circle((int) (x + (((60 * Math.cos(2 * Math.PI * (angle / 360)))))), (int) (y - (60 * Math.sin(2 * Math.PI * (angle / 360)))), 5);
        Window.out.color(30, 144, 255);
        Window.out.circle((int) (x + (((40 * Math.cos(2 * Math.PI * (angle / 360)))))), (int) (y - (40 * Math.sin(2 * Math.PI * (angle / 360)))), 5);
        Window.out.color("tan");
        Window.out.rectangle((int) (x + ((35 * Math.cos(2 * Math.PI * (angle / 360))))), (int) (y - (35 * Math.sin(2 * Math.PI * (angle / 360)))), 10, 10, 360 - angle);

    }

    public boolean checkMove(int blocksX[], int blocksY[], int size) {
        boolean cont = true;
        for (int i = 0; i < size; i++) {
            if (checkCollisionBlock(blocksX[i], blocksY[i])) {
                cont = false;
            }

        }
        return cont;

    }

    public int checkMove2(int blocksX[], int blocksY[], int size) {
        for (int i = 0; i < size; i++) {
            if (checkCollisionBlock(blocksX[i], blocksY[i])) {

                return i;
            }

        }

        return -1;
    }

    public void move(int blocksX[], int blocksY[], double angle) {
        x += Math.cos(2 * Math.PI * (angle / 360)) * speed;
        y -= Math.sin(2 * Math.PI * (angle / 360)) * speed;

    }

    public boolean checkCollisionPam(Pam p) {
        if (Math.abs(x - p.x - 50) <= radius / 2 + p.radius / 2
                && Math.abs(y - p.y - 50) <= radius / 2 + p.radius / 2) {
            return true;
        }

        return false;
    }

    public boolean checkCollisionBlock(int bX, int bY) {
        if (((x >= (bX - 22.5)) && (x <= (bX + 22.5)) && ((y >= (bY - 22.5)) && (y <= (bY + 22.5))))) {
            return true;
        }

        return false;
    }

    public boolean checkCollisionBox(int bX, int bY) {
        if (((x >= (bX)) && (x <= (bX + 50)) && ((y >= (bY)) && (y <= (bY + 50))))) {
            return true;
        }

        return false;
    }
}
