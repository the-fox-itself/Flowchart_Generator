package Mechanic;

import Objects.Block;

import javax.swing.*;
import java.awt.*;

import static Mechanic.MainVariables.*;

public class DrawPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Block block : listOfBlocks) {
            g.setColor(new Color(0));
            switch (block.type) {
                case "Circle":
                    g.setColor(new Color(0x1F53AF3B, true));
                    g.fillOval(block.xOnFrame, block.yOnFrame, block.getWidth(), block.getHeight());
                    g.setColor(new Color(0));
                    g.drawOval(block.xOnFrame, block.yOnFrame, block.getWidth(), block.getHeight());
                    break;
                case "Rectangle":
                    g.setColor(new Color(0x1F913140, true));
                    g.fillRect(block.xOnFrame, block.yOnFrame, block.getWidth(), block.getHeight());
                    g.setColor(new Color(0));
                    g.drawRect(block.xOnFrame, block.yOnFrame, block.getWidth(), block.getHeight());
                    break;
            }
            g.drawString(block.getText(), block.xOnFrame+block.getWidth()/4, block.yOnFrame+block.getHeight()/2);
        }
    }
}
