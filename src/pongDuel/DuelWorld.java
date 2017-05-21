/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongDuel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author MateusM
 */
public class DuelWorld extends javax.swing.JFrame{
    int frameWidth, frameHeight;
    List<Block> blockList = new ArrayList<Block>();
    DuelWorldPanel duelWorldPanel;
    Ball ball;
    private static DuelWorld singleton;
    
    public DuelWorld(int sizeX, int sizeY, Block block1,Block block2,Ball ball) {
        //generateWallList();
        singleton = this;
        this.ball = ball;
        this.frameWidth = sizeX;
        this.frameHeight = sizeY;
        blockList.add(block1);
        blockList.add(block2);
        duelWorldPanel = new DuelWorldPanel(this);
        this.setTitle("Player 1        Dual Pong Game          Player 2");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public int getFrameWidth() {
        return frameWidth;
    }
    
    public static DuelWorld getInstance( ) {
      return singleton;
   }
    
    public int getFrameHeight() {
        return frameHeight;
    }
    
}
