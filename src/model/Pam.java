package model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.Timer;
import java.util.TreeSet;

import view.*;
import view.Window.key;
import view.Window.out;

/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author joseportugal
 * @version May 7, 2025
 */
public class Pam extends Brawler {

    int x;
    int y;
    int speed;
    int radius;
    String color;
    int cooldown;
    String prevMove;
    int health;
    int damage = 200;
    int gems = 0;
    int direction;

    private static final double BASE_TOTAL_HEALTH = 9030.0;
    private double totalHealth;
    
    public Pam() {
        x = Window.width() / 2;
        y = Window.height() / 2;
        radius = 50;
        speed = 5;
        color = "green";
        cooldown = 9;
        totalHealth = BASE_TOTAL_HEALTH;
        health = (int)totalHealth;
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
    public double getTotalhealth() {
        return totalHealth;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }  

    public boolean shoot() {
        if (Window.key.pressed("space") && cooldown >= 9) {
            cooldown = 0;
            return true;
        }
        return false;

    }

    public void spawn(int[] bX, int bY[], Colt c) {
        x = ((int) (Math.random() * 28) * 50) + 50;
        y = ((int) (Math.random() * 16) * 50) + 50;
        boolean collision = true;
        boolean hit = false;

        while (collision) {

            for (int i = 0; i < bX.length; i++) {
                if (((x >= (bX[i] - 30)) && (x <= (bX[i] + 30)) && ((y >= (bY[i] - 30)) && (y <= (bY[i] + 30))))) {
                    x = ((int) (Math.random() * 28) * 50) + 50;
                    y = ((int) (Math.random() * 16) * 50) + 50;
                    hit = true;
                    break;
                }
                if (x == c.x && y == c.y) {
                    x = ((int) (Math.random() * 28) * 50) + 50;
                    y = ((int) (Math.random() * 16) * 50) + 50;
                    hit = true;
                    break;
                }
                if (Math.sqrt((x - c.x) * (x - c.x) + (y - c.y) * (y - c.y)) < 500) {
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

    public void draw(int dir, int counter, double angle, int pSuper) {
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
        double superFraction = pSuper / 100.0;

        if (superFraction > 1.0) {
            superFraction = 1.0;
            Window.out.color("white");
        }
        double propSuper = superFraction * 50.0;
        int intSuper = (int) propSuper;

        Window.out.rectangle(x + 55, y + 100, intSuper, 10);
        int ammo = counter / 60;
        if (dir == 0) {
            Window.out.image("src/main/resources/pamtrans.png", x, y);
        } else if (dir == 1) {
            Window.out.image("src/main/resources/pamTransREFLECT.png", x, y);
        } else {
            Window.out.image("src/main/resources/pamtrans2.png", x, y);
        }

        if (health != 0) {
            if (health < 3000) {
                Window.out.color("red");
            } else if (health < 6000) {
                Window.out.color("orange");
            } else {
                Window.out.color("green");
            }
            
            double fraction = health / totalHealth;
            double propHealth = fraction * 50.0;
            int intHealth = (int) propHealth;
            Window.out.rectangle(x + 40, y - 15, intHealth, 10);
        }

        if (ammo >= 3) {
            Window.out.color("orange");
            Window.out.rectangle(x + 23, y - 5, 15, 8);
            Window.out.rectangle(x + 40, y - 5, 15, 8);
            Window.out.rectangle(x + 57, y - 5, 15, 8);
        } else if (ammo >= 2) {
            Window.out.color("orange");
            Window.out.rectangle(x + 23, y - 5, 15, 8);
            Window.out.rectangle(x + 40, y - 5, 15, 8);
            Window.out.color("black");
            Window.out.rectangle(x + 57, y - 5, 15, 8);
            Window.out.color("gray");
            Window.out.rectangle(x + 50 + (int) ((15 * ((counter % 60) + 0.0) / 60) / 2),
                    y - 5,
                    (int) (15 * ((counter % 60) + 0.0) / 60),
                    8);

        } else if (ammo >= 1) {
            Window.out.color("orange");
            Window.out.rectangle(x + 23, y - 5, 15, 8);
            Window.out.color("black");
            Window.out.rectangle(x + 40, y - 5, 15, 8);
            Window.out.rectangle(x + 57, y - 5, 15, 8);
            Window.out.color("gray");
            Window.out.rectangle(x + 33 + (int) ((15 * ((counter % 60) + 0.0) / 60) / 2),
                    y - 5,
                    (int) (15 * ((counter % 60) + 0.0) / 60),
                    8);
        } else {
            Window.out.color("black");
            Window.out.rectangle(x + 23, y - 5, 15, 8);
            Window.out.rectangle(x + 40, y - 5, 15, 8);
            Window.out.rectangle(x + 57, y - 5, 15, 8);
            Window.out.color("gray");
            Window.out.rectangle(x + 16 + (int) ((15 * ((counter % 60) + 0.0) / 60) / 2),
                    y - 5,
                    (int) (15 * ((counter % 60) + 0.0) / 60),
                    8);
        }
        Window.out.color("black");
        Window.out.font("Times New Roman", 14);
        Window.out.print(health, x + 28, y - 25);
        Window.out.image("src/main/resources/elixir.png", x + 22, y - 62);
        Window.out.color("green");
        Window.out.print(gems, x + 51, y - 45);
    }

    public ArrayList<String> move(int blocksX[], int blocksY[]) {
        ArrayList<String> ret = new ArrayList<String>();
        if (Window.key.pressed("a")) {
            x -= speed;
            prevMove = "a";
            ret.add("a");
            for (int i = 0; i < 60; i++) {
                playerCollision(blocksX[i], blocksY[i]);
            }
        }

        if (Window.key.pressed("d")) {
            x += speed;
            prevMove = "d";
            ret.add("d");
            for (int i = 0; i < 60; i++) {
                playerCollision(blocksX[i], blocksY[i]);
            }
        }

        if (Window.key.pressed("w")) {
            y -= speed;
            prevMove = "w";
            ret.add("w");
            for (int i = 0; i < 60; i++) {
                playerCollision(blocksX[i], blocksY[i]);
            }
        }

        if (Window.key.pressed("s")) {
            y += speed;
            prevMove = "s";
            ret.add("s");
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

    public void rotate() {

        direction++;
        direction = direction % 4;

    }

    public void backtrack() {
        if (prevMove == "d") {
            x -= speed;
        }
        if (prevMove == "a") {
            x += speed;
        }

        if (prevMove == "w") {
            y += speed;
        }
        if (prevMove == "s") {
            y -= speed;
        }
    }

    public boolean isDead() {
        if (health < 0) {
            return true;
        }

        return false;
    }

    public void decreaseHealth(int dec) {
        health -= dec;
    }

    public int getHealth() {
        return health;
    }

    public void playerCollision(int bX, int bY) {
        if ((((x + 70) >= (bX - 26.25)) && ((x + 30) <= (bX + 26.25))
                && (((y + 70) >= (bY - 26.25)) && ((y + 30) <= (bY + 26.25))))) {
            backtrack();
        }
    }

    public boolean poisonCollision(int distX, int distY) {
        return !(((x + 50) > distX) && ((y + 50) > distY) && ((x + 50) < (1450 - distX)) && ((y + 50) < (900 - distY)));
    }

    public int getDirection() {
        return direction;
    }

    public void increaseHealth() {
        health = (int) Math.min(totalHealth, health + 300);

    }

    public void healFromStation(PamSuper s) {
        if ((Math.abs(x - s.x) < 50) && (Math.abs(y - s.y) < 50)) {
            if (health < totalHealth) {
                health += 500;
            }
        }
    }

    /**
     * Increases Pam's health and total health by 500 when consuming a power cube.
     * This makes the new total health the maximum for the rest of the game.
     */
    public void consumePowerCube() {
        totalHealth += 500;
        health += 500;
    }

    public void setHealth(int x) {
        health = x;
    }

}
