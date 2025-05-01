package model;

import view.*;
import view.Window.out;

/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author joseportugal
 * @version May 7, 2025
 */
public class PamBullet extends Bullet {

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
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
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
    int radius;
    String color;
    double direction;

    public PamBullet(int x, int y, double direction) {
        super(x, y);
        this.x = x + 50;
        this.y = y + 50;
        this.direction = direction;
        speed = 25;
        radius = 9;
        color = "red";
    }

    public void draw(double angle) {
        Window.out.color("white");
        Window.out.circle((int) (x + (((Math.cos(2 * Math.PI * (angle / 360)))))), (int) (y - (Math.sin(2 * Math.PI * (angle / 360)))), radius + 1);
        Window.out.color("red");
        Window.out.circle((int) (x + (((Math.cos(2 * Math.PI * (angle / 360)))))), (int) (y - (Math.sin(2 * Math.PI * (angle / 360)))), radius);
        Window.out.color("white");
        Window.out.circle((int) (x + (((Math.cos(2 * Math.PI * (angle / 360)))))), (int) (y - (Math.sin(2 * Math.PI * (angle / 360)))), radius / 2 + 1);
        Window.out.color("tan");
        Window.out.circle((int) (x + (((Math.cos(2 * Math.PI * (angle / 360)))))), (int) (y - (Math.sin(2 * Math.PI * (angle / 360)))), radius / 2);

    }

    public boolean checkMove(int blocksX[], int blocksY[]) {
        boolean cont = true;
        for (int i = 0; i < 60; i++) {
            if (checkCollisionBlock(blocksX[i], blocksY[i])) {
                cont = false;
            }

        }
        return cont;
    }

    public void move(int blocksX[], int blocksY[], double angle) {
        x += Math.cos(2 * Math.PI * (angle / 360)) * speed;
        y -= Math.sin(2 * Math.PI * (angle / 360)) * speed;

    }

    public boolean checkCollisionColt(Colt c) {
        if (((x >= (c.x)) && (x <= (c.x + 100)) && ((y >= (c.y)) && (y <= (c.y + 100))))) {
            return true;
        }

        return false;
    }

    public boolean checkCollisionBlock(int bX, int bY) {
        if (((x >= (bX - 30)) && (x <= (bX + 30)) && ((y >= (bY - 30)) && (y <= (bY + 30))))) {
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
