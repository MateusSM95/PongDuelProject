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
public class Block extends Object {

    double x, y, width, height, velocity;
    boolean outOfBound = false;
    int playerNumber = 0;

    public Block(double x, double y, double velocity, double width, double height,int playerNumber) {
        this.playerNumber = playerNumber;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        if(playerNumber == 1){
            g.drawLine((int) this.x, (int) this.y, (int) this.x, (int) (this.y+height/2));//;
            g.drawLine((int) this.x, (int) (this.y+height/2), (int) (this.x-width),(int) (this.y+height/2));//_
            g.drawLine((int) this.x, (int) this.y, (int) this.x, (int) (this.y-height/2));//:
            g.drawLine((int) this.x, (int) (this.y-height/2), (int) (this.x-width),(int) (this.y-height/2));//-
            g.drawLine((int) (this.x-width), (int) (this.y-height/2), (int) (this.x-width),(int) (this.y+height/2));//-
        }else{
            g.drawLine((int) this.x, (int) this.y, (int) this.x, (int) (this.y+height/2));//;
            g.drawLine((int) this.x, (int) (this.y+height/2), (int) (this.x+width),(int) (this.y+height/2));//_
            g.drawLine((int) this.x, (int) this.y, (int) this.x, (int) (this.y-height/2));//:
            g.drawLine((int) this.x, (int) (this.y-height/2), (int) (this.x+width),(int) (this.y-height/2));//-
            g.drawLine((int) (this.x+width), (int) (this.y-height/2), (int) (this.x+width),(int) (this.y+height/2));//-
        }
    }

    public boolean willBeOutOfBoundaries(double intentX,double intentY) {
        DuelWorld duelWorld = DuelWorld.getInstance();
        double frameWidth = duelWorld.getPanelWidth();
        double framHeight = duelWorld.getPanelHeight();
        if(playerNumber == 2){
            if ((intentX < frameWidth/ 2) || (intentY >= (framHeight - (this.height/2 -5))) || intentY <= 5 || (intentX >= frameWidth)) {
            outOfBound = true;
            } else {
                outOfBound = false;
            }
        }else{
            if ((intentX > frameWidth/ 2) || (intentY >= (framHeight - (this.height/2 -5))) || intentY <= 5 || (intentX <= 0)) {
            outOfBound = true;
            } else {
                outOfBound = false;
            }
        }
        
        return outOfBound;
    }

    @Override
    public void moveBlock(int t, Block block, direction d) {
        double intentX = this.x;
        double intentY = this.y;
        if (d == direction.forward) {
            intentY = this.y - velocity;
        }
        if (d == direction.backward) {
            intentY = this.y + velocity;
        }
        if (d == direction.right) {
            intentX = this.x + velocity;
        }
        if (d == direction.left) {
            intentX = this.x - velocity;
        }
        if(!willBeOutOfBoundaries(intentX,intentY)){
            this.x = intentX;
            this.y = intentY;
        }
    }

    @Override
    public void moveBall(int t, Block block, Block block2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
