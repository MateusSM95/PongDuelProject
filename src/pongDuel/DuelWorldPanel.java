/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongDuel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author MateusM
 */
public class DuelWorldPanel extends JPanel{
    DuelWorld duelWorld;
    List<Block> blockList;
    Agent player;
    Agent player1;
    int t = 0;
    public DuelWorldPanel(DuelWorld duelWorld) {
        this.duelWorld = duelWorld;
        this.blockList = duelWorld.blockList;
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        player = new Human(blockList.get(0),this);
        player1 = new Human(blockList.get(1),this);
        addKeyListener((KeyListener) this.player);
        addKeyListener((KeyListener) this.player1);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        //drawing the block
        blockList.get(0).paint(g);
        blockList.get(1).paint(g);
        t++;
        
       player.move(t);
    }
}
