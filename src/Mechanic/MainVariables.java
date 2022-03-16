package Mechanic;

import Objects.Block;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class MainVariables {
    public static ArrayList<Block> listOfBlocks = new ArrayList<>();

    public static Runnable runnableRepaint;
    public static Thread threadRepaint;

    public static final JFrame mainFrame = new JFrame();

    final static int widthOfScreen = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final static int heightOfScreen = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public static String currentBlockType = "";
    public static Block currentBlock = null;

    public static int x = 0;
    public static int y = 0;
}
