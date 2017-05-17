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
public abstract class Object {
    public abstract void moveBlock(int t, Block block, direction direction);
    public abstract void moveBall(int t, Block block,Block block2);
    public abstract void paint(Graphics g);
}
