package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.*;

import view.*;
import view.Window.key;
import view.Window.out;

/**
 * colt brawler contains movement, shoot, and collision methods
 *
 * @author joseportugal
 * @version May 07, 2025
 * @author Period: 5
 * @author Assignment: finalProject
 *
 * @author Sources:
 */
public class Colt extends Brawler {

    int x;
    int y;
    int speed;
    int radius;
    String color;
    int cooldown;
    int health;
    String prevMove;
    int direction;
    int damage = 400;
    int superdamage = 500;
    int gems = 0;

    private final static double TOTAL_HEALTH = 5880.0;

    /**
     * constructor
     */
    public Colt() {
        x = Window.width() / 4;
        y = Window.height() / 2;
        radius = 20;
        speed = 7;
        color = "red";
        cooldown = 9;
        health = (int)TOTAL_HEALTH;

    }

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
     * @return the cooldown
     */
    public int getCooldown() {
        return cooldown;
    }

    /**
     * @param cooldown the cooldown to set
     */
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    /**
     * @return the prevMove
     */
    public String getPrevMove() {
        return prevMove;
    }

    /**
     * @param prevMove the prevMove to set
     */
    public void setPrevMove(String prevMove) {
        this.prevMove = prevMove;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the superdamage
     */
    public int getSuperdamage() {
        return superdamage;
    }

    /**
     * @param superdamage the superdamage to set
     */
    public void setSuperdamage(int superdamage) {
        this.superdamage = superdamage;
    }

    /**
     * @return the gems
     */
    public int getGems() {
        return gems;
    }

    /**
     * @param gems the gems to set
     */
    public void setGems(int gems) {
        this.gems = gems;
    }

    /**
     * @return the totalhealth
     */
    public static double getTotalhealth() {
        return TOTAL_HEALTH;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * shoot method when "0" is pressed
     *
     * @return if shot
     */
    public boolean shoot() {
        if (Window.key.pressed("m") && cooldown >= 9) {
            cooldown = 0;
            return true;
        }
        return false;

    }

    /**
     *
     * spawns the colt at a random location
     *
     * @param bX
     * @param bY
     */
    public void spawn(int[] bX, int[] bY) {
        x = ((int) (Math.random() * 28) * 50) + 50;
        y = ((int) (Math.random() * 16) * 50) + 50;
        boolean collision = true;
        boolean hit = false;

        while (collision) {

            for (int i = 0; i < bX.length; i++) {
                if (((x >= (bX[i] - 30)) && (x <= (bX[i] + 30))
                        && ((y >= (bY[i] - 30)) && (y <= (bY[i] + 30))))) {

                    x = ((int) (Math.random() * 28) * 50) + 50;
                    y = ((int) (Math.random() * 16) * 50) + 50;
                    hit = true;
                    break;
                }

            }
            if (!hit) {
                collision = false;

            }
            hit = false;
        }

        draw(0, 0, 0, 0);
    }

    /**
     * draws colt
     *
     * @param dir
     * @param counter
     * @param angle
     * @param cSuper
     */
    public void draw(int dir, int counter, double angle, int cSuper) {
        Window.out.color("white");
        Window.out.line(((x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360))))) - 5 * Math.sin(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) - 5 * Math.cos(2 * Math.PI * (angle / 360)),
                (x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) + 5 * Math.sin(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) + 5 * Math.cos(2 * Math.PI * (angle / 360)));
        Window.out.line(((x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360))))) - 5 * Math.sin(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) - 5 * Math.cos(2 * Math.PI * (angle / 360)),
                (x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) - 5 * Math.sin(2 * Math.PI * (angle / 360)) + 40 * Math.cos(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) - 5 * Math.cos(2 * Math.PI * (angle / 360)) - 40 * Math.sin(2 * Math.PI * (angle / 360)));
        Window.out.line((x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) + 5 * Math.sin(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) + 5 * Math.cos(2 * Math.PI * (angle / 360)),
                (x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) + 5 * Math.sin(2 * Math.PI * (angle / 360)) + 40 * Math.cos(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) + 5 * Math.cos(2 * Math.PI * (angle / 360)) - 40 * Math.sin(2 * Math.PI * (angle / 360)));
        Window.out.line((x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) - 5 * Math.sin(2 * Math.PI * (angle / 360)) + 40 * Math.cos(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) - 5 * Math.cos(2 * Math.PI * (angle / 360)) - 40 * Math.sin(2 * Math.PI * (angle / 360)),
                (x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) - 5 * Math.sin(2 * Math.PI * (angle / 360)) + 40 * Math.cos(2 * Math.PI * (angle / 360)) - 5 * Math.sin(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) - 5 * Math.cos(2 * Math.PI * (angle / 360)) - 40 * Math.sin(2 * Math.PI * (angle / 360)) - 5 * Math.cos(2 * Math.PI * (angle / 360)));
        Window.out.line((x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) + 5 * Math.sin(2 * Math.PI * (angle / 360)) + 40 * Math.cos(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) + 5 * Math.cos(2 * Math.PI * (angle / 360)) - 40 * Math.sin(2 * Math.PI * (angle / 360)),
                (x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) + 5 * Math.sin(2 * Math.PI * (angle / 360)) + 40 * Math.cos(2 * Math.PI * (angle / 360)) + 5 * Math.sin(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) + 5 * Math.cos(2 * Math.PI * (angle / 360)) - 40 * Math.sin(2 * Math.PI * (angle / 360)) + 5 * Math.cos(2 * Math.PI * (angle / 360)));
        Window.out.line((x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) - 5 * Math.sin(2 * Math.PI * (angle / 360)) + 40 * Math.cos(2 * Math.PI * (angle / 360)) - 5 * Math.sin(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) - 5 * Math.cos(2 * Math.PI * (angle / 360)) - 40 * Math.sin(2 * Math.PI * (angle / 360)) - 5 * Math.cos(2 * Math.PI * (angle / 360)),
                ((x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360))))) + 50 * Math.cos(2 * Math.PI * (angle / 360)),
                ((y + 50) - ((60 * Math.sin(2 * Math.PI * (angle / 360))))) - 50 * Math.sin(2 * Math.PI * (angle / 360)));
        Window.out.line((x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360)))) + 5 * Math.sin(2 * Math.PI * (angle / 360)) + 40 * Math.cos(2 * Math.PI * (angle / 360)) + 5 * Math.sin(2 * Math.PI * (angle / 360)),
                ((y + 50) - (60 * Math.sin(2 * Math.PI * (angle / 360)))) + 5 * Math.cos(2 * Math.PI * (angle / 360)) - 40 * Math.sin(2 * Math.PI * (angle / 360)) + 5 * Math.cos(2 * Math.PI * (angle / 360)),
                ((x + 50) + ((60 * Math.cos(2 * Math.PI * (angle / 360))))) + 50 * Math.cos(2 * Math.PI * (angle / 360)),
                ((y + 50) - ((60 * Math.sin(2 * Math.PI * (angle / 360))))) - 50 * Math.sin(2 * Math.PI * (angle / 360)));
        Window.out.color("yellow");
        double superFraction = cSuper / 100.0;

        if (superFraction > 1.0) {
            superFraction = 1.0;
            Window.out.color("white");
        }
        double propSuper = superFraction * 50.0;
        int intSuper = (int) propSuper;

        Window.out.rectangle(x + 55, y + 100, intSuper, 10);
        int ammo = counter / 60;

        if (dir == 0) {
            Window.out.image("src/main/resources/coltTrans2.png", x, y);
        } else if (dir == 1) {
            Window.out.image("src/main/resources/coltTrans2REFLECT.png", x, y);
        } else {
            Window.out.image("src/main/resources/coltTrans.png", x, y);
        }

        if (health != 0) {
            if (health < 2000) {
                Window.out.color("red");
            } else if (health < 4000) {
                Window.out.color("orange");

            } else {
                Window.out.color("green");
            }
            double fraction = health / TOTAL_HEALTH;
            double propHealth = fraction * 50.0;
            int intHealth = (int) propHealth;
            Window.out.rectangle(x + 55, y - 15, intHealth, 10);
        }

        if (ammo >= 3) {
            Window.out.color("orange");
            Window.out.rectangle(x + 38, y - 5, 15, 8);
            Window.out.rectangle(x + 55, y - 5, 15, 8);
            Window.out.rectangle(x + 72, y - 5, 15, 8);
        } else if (ammo >= 2) {
            Window.out.color("orange");
            Window.out.rectangle(x + 38, y - 5, 15, 8);
            Window.out.rectangle(x + 55, y - 5, 15, 8);
            Window.out.color("black");
            Window.out.rectangle(x + 72, y - 5, 15, 8);
            Window.out.color("gray");
            Window.out.rectangle(x + 65 + (int) ((15 * ((counter % 60) + 0.0) / 60) / 2), y - 5, (int) (15 * ((counter % 60) + 0.0) / 60), 8);

        } else if (ammo >= 1) {
            Window.out.color("orange");
            Window.out.rectangle(x + 38, y - 5, 15, 8);
            Window.out.color("black");
            Window.out.rectangle(x + 55, y - 5, 15, 8);
            Window.out.rectangle(x + 72, y - 5, 15, 8);
            Window.out.color("gray");
            Window.out.rectangle(x + 48 + (int) ((15 * ((counter % 60) + 0.0) / 60) / 2), y - 5, (int) (15 * ((counter % 60) + 0.0) / 60), 8);
        } else {
            Window.out.color("black");
            Window.out.rectangle(x + 38, y - 5, 15, 8);
            Window.out.rectangle(x + 55, y - 5, 15, 8);
            Window.out.rectangle(x + 72, y - 5, 15, 8);
            Window.out.color("gray");
            Window.out.rectangle(x + 31 + (int) ((15 * ((counter % 60) + 0.0) / 60) / 2), y - 5, (int) (15 * ((counter % 60) + 0.0) / 60), 8);
        }
        Window.out.color("black");
        Window.out.font("Times New Roman", 14);
        Window.out.print(health, x + 40, y - 25);
        Window.out.image("src/main/resources/elixir.png", x + 34, y - 62);
        Window.out.color("green");
        Window.out.print(gems, x + 63, y - 45);
    }

    /**
     * moves and checks for collisions
     *
     * @param blocksX[]
     * @param blcoks[Y]
     */
    public ArrayList<String> move(int blocksX[], int blocksY[]) {
        ArrayList<String> ret = new ArrayList<String>();
        if (Window.key.pressed("left")) {
            x -= speed;
            prevMove = "left";
            ret.add("left");
            for (int i = 0; i < 60; i++) {
                playerCollision(blocksX[i], blocksY[i]);
            }
        }

        if (Window.key.pressed("right")) {
            x += speed;
            prevMove = "right";
            ret.add("right");
            for (int i = 0; i < 60; i++) {
                playerCollision(blocksX[i], blocksY[i]);
            }
        }

        if (Window.key.pressed("up")) {
            y -= speed;
            prevMove = "up";
            ret.add("up");
            for (int i = 0; i < 60; i++) {
                playerCollision(blocksX[i], blocksY[i]);
            }
        }

        if (Window.key.pressed("down")) {
            y += speed;
            prevMove = "down";
            ret.add("down");
            for (int i = 0; i < 60; i++) {
                playerCollision(blocksX[i], blocksY[i]);
            }
        }
        if (x > Window.width() - 101) {
            x = Window.width() - 101;
        } else if (x < 1) {
            x = 1;
        }
        if (y > Window.height() - 101) {
            y = Window.height() - 101;
        } else if (y < 1) {
            y = 1;
        }

        cooldown++;
        return ret;
    }

    /**
     *
     * backtracks once collision is hit
     */
    public void backtrack() {
        if (prevMove == "left") {
            x += speed;
        }
        if (prevMove == "right") {
            x -= speed;
        }
        if (prevMove == "up") {
            y += speed;
        }

        if (prevMove == "down") {
            y -= speed;
        }
    }

    /**
     * checks whether colt's health is less than 0
     */
    public boolean isDead() {
        if (health < 0) {
            return true;
        }

        return false;
    }

    /**
     *
     * rotates colt
     */
    public void rotate() {
        direction++;
        direction = direction % 4;
    }

    /**
     *
     * gets health
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     *
     * decreases colts health
     *
     * @param dec
     */
    public void decreaseHealth(int dec) {
        health -= dec;
    }

    /**
     *
     * checks if there is a collision with pam
     *
     * @param bX
     * @param bY
     */
    public void playerCollision(int bX, int bY) {
        if ((((x + 70) >= (bX - 26.25)) && ((x + 30) <= (bX + 26.25))
                && (((y + 70) >= (bY - 26.25)) && ((y + 30) <= (bY + 26.25))))) {
            backtrack();
        }
    }

    /**
     *
     * collisions with poison
     *
     * @param distX
     * @param distY
     * @return if collision
     */
    public boolean poisonCollision(int distX, int distY) {
        return !(((x + 50) > distX) && ((y + 50) > distY) && ((x + 50) < (1450 - distX)) && ((y + 50) < (900 - distY)));
    }

    /**
     *
     * gets direction
     *
     * @return direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     *
     * increments health
     */
    public void increaseHealth() {
        health = (int) Math.min(TOTAL_HEALTH, health + 300);

    }

    /**
     *
     * returns true if "1" is pressed
     *
     * @return if coltsuper
     */
    public boolean coltSuper() {
        if (Window.key.pressed("l")) {
            return true;
        }
        return false;
    }

    public void setHealth(int x) {
        health = x;
    }

}
