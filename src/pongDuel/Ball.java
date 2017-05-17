/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongDuel;

import java.awt.Graphics;

/**
 *
 * @author MateusM
 */
public class Ball extends Object {
    Graphics g;
    int t = 0;
    double x = 0;
    double y = 0;
    double frameWidth, frameHight;
    boolean xPositive = true;
    boolean yPositive = true;

    public Ball(double x, double y,double frameWidth, double frameHight) {
        this.frameWidth = frameWidth;
        this.frameHight = frameHight;
    }
    @Override
    public void paint(Graphics g) {
        this.g = g;
        g.fillOval((int)this.x,(int) this.y, 10, 10);
    }

    @Override
    public void moveBall(int t, Block blockP1, Block blockP2) {
        playerCollider(blockP1, blockP2);
        if (xPositive) {
            this.x += 1;
            if (this.x >= this.frameWidth - 10) {
                xPositive = false;
            }
        } else {
            this.x -= 1;
            if (this.x <= 0) {
                this.xPositive = true;
            }
        }
        if (yPositive) {
            this.y += 1;
            if (this.y >= frameHight - 10) {
                yPositive = false;
            }
        } else {
            this.y -= 1;
            if (this.y <= 0) {  
                yPositive = true;
            }
        }
    }

    public void playerCollider(Block blockP1, Block blockP2) {
        if ((Math.abs(blockP1.x - this.x) >= 0 && (Math.abs(blockP1.x - this.x) <= 5)) && (Math.abs(blockP1.y - this.y) >= 0 && Math.abs(blockP1.y - this.y) <= 20)) {
            this.xPositive = false;
        }
        if ((Math.abs(blockP2.x - this.x) >= 0 && (Math.abs(blockP2.x - this.x) <= 5)) && (Math.abs(blockP2.y - this.y) >= 0 && Math.abs(blockP2.y - this.y) <= 20)) {
            this.xPositive = true;
        }
    }

    @Override
    public void moveBlock(int t, Block block, direction d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
