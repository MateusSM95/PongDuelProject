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
    double x = 4;
    double y;
    double frameWidth, frameHight;
    boolean xPositive = true;
    boolean yPositive = true;
    double velocity= 4;

    public Ball(double x, double y,double frameWidth, double frameHight) {
        this.frameWidth = frameWidth;
        this.frameHight = frameHight;
        this.y = frameHight/2;
    }
    @Override
    public void paint(Graphics g) {
        this.g = g;
        g.fillOval((int)this.x,(int) this.y, 10, 10);
    }

    @Override
    public void moveBall(int t, Block blockP1, Block blockP2) {
        playerCollider(blockP1, blockP2);
        //System.out.println("x:"+x+"Positive:"+xPositive);
        if (xPositive) {
            this.x += velocity;
            if (this.x >= this.frameWidth -10) {
                xPositive = false;
            }
        } else {
            this.x -= velocity;
            if (this.x <= 0) {
                this.xPositive = true;
            }
        }
        if (yPositive) {
            this.y += velocity;
            if (this.y >= frameHight -10){
                yPositive = false;
            }
        } else {
            this.y -= velocity;
            if (this.y <= 2) {  
                yPositive = true;
            }
        }
    }

    public void playerCollider(Block blockP1, Block blockP2) {
        if(this.x <= frameWidth/2){//do lado do P1
            if ((Math.abs(blockP1.x - this.x) <= 3) && (Math.abs(blockP1.y - this.y) <= blockP1.height/2 )) {
                if(!this.xPositive){
                    this.xPositive = true;
                }
            }
        }else{//do lado do P2
            if ((Math.abs(blockP2.x - this.x) <= 3) && (Math.abs(blockP2.y - this.y) <= blockP1.height/2 )) {
                if(this.xPositive){
                    this.xPositive = false;
                }
            }
        }
    }

    @Override
    public void moveBlock(int t, Block block, direction d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
