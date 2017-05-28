/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongDuel;

/**
 *
 * @author MateusM
 */
public class Main {
    public static void main(String[] args){
        double blockX,blockY,velocity;
        double block1X,block1Y,velocity1;
        double panelWidth,panelHight;
        panelWidth = 654;
        panelHight = 434;
        blockX = 8;
        blockY = panelHight/2;
        block1X = panelWidth-8;
        block1Y = panelHight/2;
        velocity = 10;
        velocity1 = 10;
        
        Ball ball = new Ball(2,169,panelWidth,panelHight);
        Block block1 = new Block(blockX,blockY,velocity,5,30,1);
        Block block2 = new Block(block1X,block1Y,velocity1,5,30,2);
        DuelWorld duelWorld = new DuelWorld(panelWidth,panelHight,block1,block2,ball);
    }
}
