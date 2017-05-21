/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongDuel;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
    Human player1;
    Human player2;
    Ball ball;
    int t = 0;
    int controlScore = 0;
    
    public DuelWorldPanel(DuelWorld duelWorld) {
        this.duelWorld = duelWorld;
        this.blockList = duelWorld.blockList;
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.setPreferredSize(new Dimension(duelWorld.frameWidth, duelWorld.frameHeight));// changed it to preferredSize, Thanks!
        duelWorld.getContentPane().add( this );// adding to content pane will work here. Please read the comment bellow.
        duelWorld.pack();
        duelWorld.setVisible(true);
        System.out.println("jFrame:"+duelWorld.getBounds());
        System.out.println("jPanel:"+this.getBounds());
        this.ball = duelWorld.ball;
        player1 = new Human(1,blockList.get(0),this);
        player2 = new Human(2,blockList.get(1),this);
        addKeyListener((KeyListener) this.player1);
        addKeyListener((KeyListener) this.player2);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        //drawing the block
        g.drawLine(duelWorld.frameWidth/2, duelWorld.frameHeight, duelWorld.frameWidth/2, 0);
        g.drawString("Score Player 1: "+Integer.toString(player1.getScore()), duelWorld.frameWidth-100, 10);
        g.drawString("Score Player 2: "+Integer.toString(player2.getScore()), 0,10);
        
        t++;
        ball.paint(g);
        player1.block.paint(g);
        player2.block.paint(g);
        ball.moveBall(t, player1.block, player2.block);
        player1.move(t);
        player2.move(t);
    }
}
