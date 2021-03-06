/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongDuel;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pongDuel.direction.backward;
import static pongDuel.direction.forward;
import static pongDuel.direction.left;
import static pongDuel.direction.right;

/**
 *
 * @author MateusM
 */
public class Human extends Agent implements blockChangeListener, Runnable{
    int t = 0;
    DuelWorldPanel duelWorldPanel;
    Block block;
    int id;
    int score = 0;
    boolean isGoal = false;
    
    boolean dPressed,uPressed,lPressed,rPressed = false;
    public Human(int id,Block block,DuelWorldPanel duelWorldPanel) {
        Thread thread = new Thread(this);
        thread.start();
        this.id = id;
        this.block = block;
        this.duelWorldPanel = duelWorldPanel;
    }

    @Override
    public void blockMoved() {
        duelWorldPanel.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            dPressed = true;         
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            uPressed = true;  
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            lPressed = true;  
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rPressed = true;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            dPressed = true;         
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            uPressed = true;  
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            lPressed = true;  
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            dPressed = false;         
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            uPressed = false;  
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            lPressed = false;  
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rPressed = false;
        }
    }

    @Override
    public void run() {
        while(true){
            if(dPressed){
                t+=1;
                block.moveBlock(t,block,backward);           
            }
            if(uPressed){
                t+=1;
                block.moveBlock(t,block,forward);
            }
            if(lPressed){
                t+=1;
                block.moveBlock(t,block,left);
            }
            if(rPressed){
                t+=1;
                block.moveBlock(t,block,right);
            }
            System.out.println("t:"+t);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
            }
            blockMoved();
        }
    }

    @Override
    public void move(int t) {
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isIsGoal() {
        return isGoal;
    }

    public void setIsGoal(boolean isGoal) {
        this.isGoal = isGoal;
    }
    
}
