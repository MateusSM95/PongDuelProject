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
public class Block extends Object{
    double x, y, width, height,velocity;
    boolean outOfBound = false;
    
    public Block(double x, double y, double velocity, double width,double height){
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.width = width;
        this.height = height;
    }
    public void paint(Graphics g){
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }
    
    public boolean willBeOutOfBoundaries(double frameWidth,double frameHeight){
        if((this.x < frameWidth/2)|| (this.y >= frameHeight - 30) || (this.x >= frameWidth)){
            outOfBound = true;
        }else{
            outOfBound = false;
        }
        return outOfBound;
    }

    @Override
    public void moveBlock(int t, Block block,direction d) {
        
    }

    @Override
    public void moveBall(int t, Block block, Block block2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
