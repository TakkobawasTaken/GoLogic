package org.example;


import gui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        newGame(19, 0);

    }

    /**
     * New game
     * @param size size of goban
     * @param handicap number of handicap
     */
    public static void newGame(int size, int handicap) {
        Goban goban = new Goban(size,size, handicap);
        GUI gui = new GUI(goban);
    }

    /**
     * Loading game
     * @param filepath the location of the file we want to load
     */
    public static void loadGame(String filepath) {
        GameRecord gr = GameRecord.load(filepath);
        Goban goban = new Goban(gr);
        GUI gui = new GUI(goban);
    }
}