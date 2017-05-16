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
        blockX = 0;
        blockY = 10;
        block1X = 0;
        block1Y = 10;
        velocity = 1;
        velocity1 = 1;
               
        Block block1 = new Block(blockX,blockY,velocity);
        Block block2 = new Block(block1X,block1Y,velocity1);
        DuelWorld duelWorld = new DuelWorld(100,100,block1,block2);
    }
}
