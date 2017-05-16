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
public class DuelWorld {
    int sizeX, sizeY;
    List<Block> blockList = new ArrayList<Block>();
    DuelWorldPanel duelWorldPanel;
    
    public DuelWorld(int sizeX, int sizeY, Block block1,Block block2) {
        //generateWallList();
        blockList.add(block1);
        blockList.add(block2);
        duelWorldPanel = new DuelWorldPanel(this);
        JFrame jFrame = new JFrame("Teste");
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setSize(sizeX, sizeY);
        jFrame.add(duelWorldPanel);
        jFrame.setVisible(true);
    }
}
