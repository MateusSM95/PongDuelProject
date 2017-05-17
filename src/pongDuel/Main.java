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
        blockX = 1;
        blockY = 169;
        block1X = 410;
        block1Y = 169;
        velocity = 1;
        velocity1 = 1;
        
        Ball ball = new Ball(2,169,414,335);
        Block block1 = new Block(blockX,blockY,velocity,5,30);
        Block block2 = new Block(block1X,block1Y,velocity1,5,30);
        DuelWorld duelWorld = new DuelWorld(416,339,block1,block2,ball);
    }
}
