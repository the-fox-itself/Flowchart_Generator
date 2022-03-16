package Mechanic;

import Objects.Block;
import Objects.BlockCircle;
import Objects.BlockRectangle;

import javax.swing.*;

import java.awt.event.*;

import static Mechanic.MainVariables.*;

public class MainMechanic {
    void preparation() {
        mainFrame.setSize(widthOfScreen, heightOfScreen);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        DrawPanel drawPanel = new DrawPanel();
        mainFrame.add(drawPanel);
        drawPanel.setBounds(0, 0, mainFrame.getWidth(), mainFrame.getHeight());
        mainFrame.addKeyListener(new FrameKeyListener());
        mainFrame.addMouseListener(new FrameMouseListener());
        mainFrame.addMouseMotionListener(new FrameMouseMotionListener());
        mainFrame.addMouseWheelListener(new FrameMouseWheelListener());

        BlockCircle blockCircle = new BlockCircle(100, 100, "Начало");
        listOfBlocks.add(blockCircle);

        mainFrame.setVisible(true);
        preparationRunnable();
    }
    void preparationRunnable() {
        runnableRepaint = () -> {
            while (true) {
                mainFrame.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        threadRepaint = new Thread(runnableRepaint);
        threadRepaint.start();
    }
    boolean isCollision(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2) {
        for (int x = x1; x < width1; x++) {

        }
        return false;
    }

    private class FrameKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyChar()) {
                case '0':
                    currentBlockType = "";
                    break;
                case '1':
                    currentBlockType = "Circle";
                    break;
                case '2':
                    currentBlockType = "Rectangle";
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class FrameMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (currentBlockType != null) {
                switch (currentBlockType) {
                    case "Circle":
                        BlockCircle blockCircle = new BlockCircle(e.getX() - 50, e.getY() - 50, "Начало");
                        listOfBlocks.add(blockCircle);
                        currentBlock = blockCircle;
                        break;
                    case "Rectangle":
                        BlockRectangle blockRectangle = new BlockRectangle(e.getX() - 50, e.getY() - 50, "Действие");
                        listOfBlocks.add(blockRectangle);
                        currentBlock = blockRectangle;
                        break;
                    case "":
                        x = e.getX();
                        y = e.getY();
                        break;
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class FrameMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentBlockType != null) {
                switch (currentBlockType) {
                    case "":
                        for (Block block : listOfBlocks) {
                            block.xOnFrame = block.xOnFrame + (e.getX() - x);
                            block.yOnFrame = block.yOnFrame + (e.getY() - y);
                        }
                        x = e.getX();
                        y = e.getY();
                        break;
                    case "Circle":
                    case "Rectangle":
                        currentBlock.xOnFrame = e.getXOnScreen() - 50;
                        currentBlock.yOnFrame = e.getYOnScreen() - 50;
                        break;
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    private class FrameMouseWheelListener implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }
    }
}
